package com.cordingrecipe.scheduledevelop.service;


import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleUpdateDto;
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

    //생성
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getTodoTitle(), requestDto.getTodoContents());

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }
    //조회
    public List<ScheduleFindAllResponseDto> findAll() {
        return  scheduleRepository.findAll()
                .stream()
                .map(ScheduleFindAllResponseDto::toDto)
                .toList();
    }
    //id로 조회
    public ScheduleFindByIdResponseDto findById(Long id) {
        Schedule byIdOrElseThrow = scheduleRepository.findByIdOrElseThrow(id);
        return new ScheduleFindByIdResponseDto(byIdOrElseThrow);
    }

    //id, dto를 받으면 ->일정 제목 ,일정 내용 수정.
    public ScheduleFindByIdResponseDto updateSchedule(Long id, ScheduleUpdateDto dto) {
        //id에 해당하는 Entity 찾기
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id); //id 로조회
        schedule.updateSchedule(dto.getTodoTitle(), dto.getTodoContents()); //조회한 id entity 에 수정 제목,컨텐츠 주입
        Schedule saveSchedule = scheduleRepository.save(schedule); //데이터베이스에 save
        return new ScheduleFindByIdResponseDto(saveSchedule); //바뀐 entity 출력.
    }

    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
