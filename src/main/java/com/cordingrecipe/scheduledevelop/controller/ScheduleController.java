package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindAllResponseDto;
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
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto responseDto = scheduleService.saveSchedule(requestDto);
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ScheduleFindAllResponseDto>> findAll() {
        List<ScheduleFindAllResponseDto> findAllResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(findAllResponseDtoList,HttpStatus.OK);
    }


}
