package com.cordingrecipe.scheduledevelop.service;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.entity.User;
import com.cordingrecipe.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignupResponseDto signUp(SignUpRequestDto dto){
        User user =new User(dto.getUsername(),dto.getEmail(),dto.getPassword());
        User saveUser = userRepository.save(user);
        return new SignupResponseDto(saveUser);
    }

    public UserFindByIdResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id= "+ id);
        }

        User findUser = optionalUser.get();
        return new UserFindByIdResponseDto(findUser);
    }
}
