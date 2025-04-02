package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    //일정 생성요청 dto
    private Long id;
    private String todoTitle;
    private String todoContents;

    public ScheduleRequestDto(Long id,String todoTitle, String todoContents) {
        this.id=id;

        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
