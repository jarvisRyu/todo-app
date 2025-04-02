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

    private final ScheduleService scheduleService;

    //생성 - user 테이블에 id가 있으면 생성되게해야함.   ?
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.saveSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    //전체조회
    @GetMapping
    public ResponseEntity<List<ScheduleFindAllResponseDto>> findAll() {
        List<ScheduleFindAllResponseDto> findAllResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(findAllResponseDtoList, HttpStatus.OK);
    }
    //id 조회 -user id로 바꿔야함.
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleFindByIdResponseDto> findById(@PathVariable Long id) {
        ScheduleFindByIdResponseDto scheduleFindByIdResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleFindByIdResponseDto, HttpStatus.OK);
    }
    //일정수정 - 제목과,일정만 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleFindByIdResponseDto> updateSchedule(@PathVariable Long id,
                                                                      @RequestBody ScheduleUpdateDto dto){
        ScheduleFindByIdResponseDto updateSchedule = scheduleService.updateSchedule(id, dto);
        return new ResponseEntity<>(updateSchedule,HttpStatus.OK);
    }
    //일정삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
