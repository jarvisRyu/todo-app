package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class ScheduleUpdateDto {

    private String todoTitle;
    private String todoContents;

    public ScheduleUpdateDto(String todoTitle, String todoContents) {
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
