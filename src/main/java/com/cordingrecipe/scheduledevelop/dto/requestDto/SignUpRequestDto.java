package com.cordingrecipe.scheduledevelop.dto.requestDto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String username;
    private String email;
    private String password;

    public SignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
