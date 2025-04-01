package com.cordingrecipe.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String todoTitle;

    private String todoContents;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

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

