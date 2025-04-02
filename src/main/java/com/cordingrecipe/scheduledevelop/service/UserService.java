package com.cordingrecipe.scheduledevelop.service;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.entity.User;
import com.cordingrecipe.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignupResponseDto signUp(SignUpRequestDto dto){
        User user =new User(dto.getUsername(),dto.getEmail(),dto.getPassword());
        User saveUser = userRepository.save(user);
        return new SignupResponseDto(saveUser);
    }
}
