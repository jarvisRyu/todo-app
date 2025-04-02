package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleFindAllResponseDto {

    //생성시 보여지는 dto
    private Long id;
    private Long userId;
    private String username;
    private String todoTitle;


    public ScheduleFindAllResponseDto(Long id, Long userId, String username, String todoTitle) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.todoTitle = todoTitle;
    }

    public static ScheduleFindAllResponseDto toDto(Schedule schedule) {
        return new ScheduleFindAllResponseDto(schedule.getId(), schedule.getUser().getId(), schedule.getUser().getUsername(), schedule.getTodoTitle());
    }


}


