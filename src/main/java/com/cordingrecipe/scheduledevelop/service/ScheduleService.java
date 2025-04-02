package com.cordingrecipe.scheduledevelop.service;


import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.ScheduleUpdateDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import com.cordingrecipe.scheduledevelop.entity.Schedule;
import com.cordingrecipe.scheduledevelop.entity.User;
import com.cordingrecipe.scheduledevelop.repository.ScheduleRepository;
import com.cordingrecipe.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    //생성
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        //입력받은 값 id,username,title,contents

        User byIdOrElseThrow = userRepository.findByIdOrElseThrow(requestDto.getId());
        //입력된 id검증 없으면 NOT_FOUND
        Schedule schedule = new Schedule(requestDto.getTodoTitle(), requestDto.getTodoContents());
        //새일정 생성: 이름,할일,내용 담아주기
        schedule.setUser(byIdOrElseThrow);
        //대칭키 User 생성키 넣어주기
        Schedule saveSchedule = scheduleRepository.save(schedule);
        //DB에 저장
        return new ScheduleResponseDto(saveSchedule);
    }
    //전체 조회
    public List<ScheduleFindAllResponseDto> findAll() {
        return  scheduleRepository.findAll()
                .stream()
                .map(ScheduleFindAllResponseDto::toDto)
                .toList();
    }
    //id로 조회
    public ScheduleFindByIdResponseDto findById(Long id) {
        Schedule byIdOrElseThrow = scheduleRepository.findByIdOrElseThrow(id); //입력한 id로 조회한값 불러옴

        return new ScheduleFindByIdResponseDto(byIdOrElseThrow); //반환값 id,title,contents,작성일,수정일
    }

    //id, dto 를 받으면 ->일정 제목 ,일정 내용 수정.
    @Transactional
    public ScheduleFindByIdResponseDto updateSchedule(Long id, ScheduleUpdateDto dto) {
        //id에 해당하는 Entity 찾기
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id); //id로 조회
        schedule.updateSchedule(dto.getTodoTitle(), dto.getTodoContents()); //조회한 id entity 에 수정 제목,컨텐츠 주입
        Schedule saveSchedule = scheduleRepository.save(schedule); //데이터베이스에 save
        return new ScheduleFindByIdResponseDto(saveSchedule); //바뀐 entity 출력.
    }
    //일정 삭제
    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
