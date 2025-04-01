package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    // request dto
    private String username;

    private String todoTitle;

    private String todoContents;

    public ScheduleRequestDto(String username, String todoTitle, String todoContents) {
        this.username = username;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
