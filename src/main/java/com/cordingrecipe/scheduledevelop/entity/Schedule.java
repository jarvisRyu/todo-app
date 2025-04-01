package com.cordingrecipe.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String todoTitle;

    private String todoContents;

    public Schedule(){} //기본생성자

    public Schedule(String username, String todoTitle, String todoContents) {
        this.username = username;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
    public void updateSchedule(String todoTitle,String todoContents){
        this.todoTitle=todoTitle;
        this.todoContents=todoContents;
    }
}

