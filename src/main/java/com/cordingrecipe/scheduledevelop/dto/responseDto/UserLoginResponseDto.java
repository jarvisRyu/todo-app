package com.cordingrecipe.scheduledevelop.dto.responseDto;

import lombok.Getter;

@Getter
public class UserLoginResponseDto {

    private Long id;


    public UserLoginResponseDto(Long id) {
        this.id = id;

    }
}
