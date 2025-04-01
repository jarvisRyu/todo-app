package com.cordingrecipe.scheduledevelop.service;


import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import com.cordingrecipe.scheduledevelop.entity.Schedule;
import com.cordingrecipe.scheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getUsername(), requestDto.getTodoTitle(), requestDto.getTodoContents());

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    public List<ScheduleFindAllResponseDto> findAll() {
        return  scheduleRepository.findAll()
                .stream()
                .map(ScheduleFindAllResponseDto::toDto)
                .toList();

    }

    public ScheduleFindByIdResponseDto findById(Long id) {
        Schedule byIdOrElseThrow = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleFindByIdResponseDto(byIdOrElseThrow);
    }
}
