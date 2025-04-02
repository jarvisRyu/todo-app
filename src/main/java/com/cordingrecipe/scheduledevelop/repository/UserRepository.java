package com.cordingrecipe.scheduledevelop.repository;

import com.cordingrecipe.scheduledevelop.dto.requestDto.UserUpdateRequestDto;
import com.cordingrecipe.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //이름으로 유저 정보조회
    Optional<User> findUserByUsername(String username);

    default User findUserByNameOrElseThrow(String username){
        return findUserByUsername(username).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist username ="+username));
    }
    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }


}

