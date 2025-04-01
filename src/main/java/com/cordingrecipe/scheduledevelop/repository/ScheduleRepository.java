package com.cordingrecipe.scheduledevelop.repository;

import com.cordingrecipe.scheduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {


}
