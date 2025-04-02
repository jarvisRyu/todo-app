package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleFindByIdResponseDto {

    private Long id;
//    private String username;
    private String todoTitle;
    private String todoContents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleFindByIdResponseDto(Schedule schedule) {
        this.id = schedule.getId();
//        this.username = schedule.getUsername();
        this.todoTitle = schedule.getTodoTitle();
        this.todoContents = schedule.getTodoContents();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

}
