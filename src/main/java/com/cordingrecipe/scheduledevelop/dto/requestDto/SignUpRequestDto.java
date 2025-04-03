package com.cordingrecipe.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank(message = "유저명은 필수 입니다.")
    private String username;

    @NotBlank
    @Email(message = "이메일 형식으로 작성해주세요.")
    private String email;

    @NotNull
    private String password;

    public SignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
