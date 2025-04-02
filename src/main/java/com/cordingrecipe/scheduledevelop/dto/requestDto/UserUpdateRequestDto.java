package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private String password;
    private String username;
    private String email;

    public UserUpdateRequestDto(String password, String username, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
    }
}
