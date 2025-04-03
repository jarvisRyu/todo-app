package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserSignupResponseDto {

    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;


    public UserSignupResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();

    }
}
