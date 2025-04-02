package com.cordingrecipe.scheduledevelop.service;

import com.cordingrecipe.scheduledevelop.dto.requestDto.SignUpRequestDto;
import com.cordingrecipe.scheduledevelop.dto.requestDto.UserUpdateRequestDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.ScheduleFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.SignupResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindAllResponseDto;
import com.cordingrecipe.scheduledevelop.dto.responseDto.UserFindByIdResponseDto;
import com.cordingrecipe.scheduledevelop.entity.Schedule;
import com.cordingrecipe.scheduledevelop.entity.User;
import com.cordingrecipe.scheduledevelop.repository.ScheduleRepository;
import com.cordingrecipe.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    //유저 생성
    public SignupResponseDto signUp(SignUpRequestDto dto) {
        User user = new User(dto.getUsername(), dto.getEmail(), dto.getPassword());
        User saveUser = userRepository.save(user);
        return new SignupResponseDto(saveUser);
    }

    //유저 id조회
    public UserFindByIdResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id= " + id);
        }

        User findUser = optionalUser.get();
        return new UserFindByIdResponseDto(findUser);
    }

    //유저 전체조회
    public List<UserFindAllResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserFindAllResponseDto::toDto)
                .toList();
    }

    //유저 정보수정  - 비밀번호 입력 하면 (이름,이메일 수정)
    @Transactional
    public UserFindByIdResponseDto updateUser(Long id, UserUpdateRequestDto dto) {
        User byIdOrElseThrow = userRepository.findByIdOrElseThrow(id);
        if (!byIdOrElseThrow.getPassword().equals(dto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지않습니다.");
        }
        byIdOrElseThrow.updateUser(dto.getUsername(), dto.getEmail());
        return new UserFindByIdResponseDto(byIdOrElseThrow);
    }

    //유저 정보삭제 -비밀번호 입력하고 맞으면 해당게시글 먼저 다 삭제
    @Transactional
    public void deleteUser(Long id, String password) {
        User userToDelete = userRepository.findByIdOrElseThrow(id); //입력 id에 해당하는 유저정보 찾음

        if (!password.equals(userToDelete.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지않습니다.");
        }//비밀번호 일치하면
        List<Schedule> userSchedules = scheduleRepository.findAllByUserId(id);//id로 작성한 게시글 리스트
        scheduleRepository.deleteAll(userSchedules); //전부삭제

        userRepository.delete(userToDelete);
    }
}
//user 삭제


