package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop. entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleFindAllResponseDto {

    //생성시 보여지는 dto
    private Long id;
    private String username;
    private String todoTitle;

    public ScheduleFindAllResponseDto(Long id, String username, String todoTitle) {
        this.id = id;
        this.username = username;
        this.todoTitle = todoTitle;
    }

    public static ScheduleFindAllResponseDto toDto(Schedule schedule) {
        return new ScheduleFindAllResponseDto(schedule.getId(),schedule.getUsername(),schedule.getTodoTitle());
    }

}


