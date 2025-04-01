package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleUpdateDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import com.cordingrecipe.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//컨트롤러
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    //
    private final ScheduleService scheduleService;


    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.saveSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ScheduleFindAllResponseDto>> findAll() {
        List<ScheduleFindAllResponseDto> findAllResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(findAllResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleFindByIdResponseDto> findById(@PathVariable Long id) {
        ScheduleFindByIdResponseDto scheduleFindByIdResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleFindByIdResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleFindByIdResponseDto> updateSchedule(@PathVariable Long id,
                                                                      @RequestBody ScheduleUpdateDto dto){
        ScheduleFindByIdResponseDto updateSchedule = scheduleService.updateSchedule(id, dto);
        return new ResponseEntity<>(updateSchedule,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
