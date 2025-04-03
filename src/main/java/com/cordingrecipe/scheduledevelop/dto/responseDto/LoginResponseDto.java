package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {

    private Long id;


    public LoginResponseDto(Long id) {
        this.id = id;

    }
}
