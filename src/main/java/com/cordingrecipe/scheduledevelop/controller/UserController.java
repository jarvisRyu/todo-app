package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindByIdResponseDto;
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
//
//    @GetMapping
//    public ResponseEntity<>

    //user id로 조회하기
    @GetMapping("/{id}") //user아이디로 조회하기
    public ResponseEntity<UserFindByIdResponseDto> findById(@PathVariable Long id){
        UserFindByIdResponseDto userById = userService.findById(id);

        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
}
