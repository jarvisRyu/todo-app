package com.cordingrecipe.scheduledevelop.repository;

import com.cordingrecipe.scheduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    default Schedule findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id ="+id));
    }//id가 있으면 찾아주고 없으면 throw


    List<Schedule> findAllByUserId(Long id);
}
