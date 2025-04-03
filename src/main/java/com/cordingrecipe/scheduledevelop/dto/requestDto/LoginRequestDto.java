package com.cordingrecipe.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    //사용자 입력아이디
    @NotBlank
    private final String email;
    //사용자 입력패스워드
    @NotNull
    private final String password;

}
