package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    //생성시 보여지는 dto
    private Long id;
    private String username;
    private String todoTitle;
    private String todoContents;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUser().getUsername();
        this.todoTitle = schedule.getTodoTitle();
        this.todoContents = schedule.getTodoContents();
        this.createdAt = schedule.getCreatedAt();
    }
}
