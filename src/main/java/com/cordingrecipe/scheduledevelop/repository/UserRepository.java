package com.cordingrecipe.scheduledevelop.repository;

import com.cordingrecipe.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
