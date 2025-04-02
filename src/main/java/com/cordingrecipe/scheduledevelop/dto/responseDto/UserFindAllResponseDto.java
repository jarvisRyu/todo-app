package com.cordingrecipe.scheduledevelop.dto.responseDto;

import com.cordingrecipe.scheduledevelop.entity.User;
import lombok.Getter;

@Getter
public class UserFindAllResponseDto {

    private Long id;
    private String username;
    private String email;

    public UserFindAllResponseDto(Long id, String username, String email) {
        this.id=id;
        this.username=username;
        this.email=email;
    }

    public static UserFindAllResponseDto toDto(User user) {
        return new UserFindAllResponseDto(user.getId(),user.getUsername(),user.getEmail());
    }

}
