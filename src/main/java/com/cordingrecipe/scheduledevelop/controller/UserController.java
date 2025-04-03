package com.cordingrecipe.scheduledevelop.controller;

import com.cordingrecipe.scheduledevelop.dto.responseDto.UserLoginResponseDto;
import com.cordingrecipe.scheduledevelop.filter.Const;
import com.cordingrecipe.scheduledevelop.dto.requestDto.LoginRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.UserUpdateRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserSignupResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //user 생성-회원가입
    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        UserSignupResponseDto userSignupResponseDto = userService.signUp(requestDto);
        return new ResponseEntity<>(userSignupResponseDto, HttpStatus.CREATED);
    }

    //user 전체조회
    @GetMapping
    public ResponseEntity<List<UserFindAllResponseDto>> findAll() {
        List<UserFindAllResponseDto> findAllResponseDtos = userService.findAll();
        return new ResponseEntity<>(findAllResponseDtos, HttpStatus.OK);
    }

    //user id로 조회하기
    @GetMapping("/{id}") //user아이디로 조회하기
    public ResponseEntity<UserFindByIdResponseDto> findById(@PathVariable Long id) {
        UserFindByIdResponseDto userById = userService.findById(id);

        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    //user 수정
    @PatchMapping("/{id}")
    public ResponseEntity<UserFindByIdResponseDto> updateUser(@PathVariable Long id,
                                                              @RequestBody UserUpdateRequestDto dto) {
        UserFindByIdResponseDto updatedUser = userService.updateUser(id, dto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //유저삭제 - 삭제시 id로 생성된 일정들도 삭제되어야함.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id,
                                           @RequestParam(required = true) String password) {
        userService.deleteUser(id, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //로그인기능
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto,
                                                      HttpServletRequest httpServletRequest){

        //이메일과 비밀번호로 id찾기
        UserLoginResponseDto responseDto  = userService.login(requestDto);
        Long userId = responseDto.getId();
        //로그인 실패시
        if(userId==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //맞으면 세션 생성하고 저장
        HttpSession session = httpServletRequest.getSession(true);
        //회원 정보 조회
        UserFindByIdResponseDto loginUser = userService.findById(userId);
        //Session에 정보저장
        session.setAttribute(Const.LOGIN_USER,loginUser);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

}



