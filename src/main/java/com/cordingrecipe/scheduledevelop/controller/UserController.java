package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //생성-회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
        SignupResponseDto signupResponseDto = userService.signUp(requestDto);
        return new ResponseEntity<>(signupResponseDto, HttpStatus.CREATED);
    }

}
