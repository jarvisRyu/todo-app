package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.entity.User;
import com.cordingrecipe.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    //user id로 조회하기
//    @GetMapping("/{id}") //id 조회시
//    public ResponseEntity<UserRes>
}
