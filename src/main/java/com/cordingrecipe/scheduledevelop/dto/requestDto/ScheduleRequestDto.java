package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    // request dto
    private Long id;

    private String username;

    private String todoTitle;

    private String todoContents;

    public ScheduleRequestDto(Long id,String username, String todoTitle, String todoContents) {
        this.id=id;
        this.username = username;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
