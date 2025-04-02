package com.cordingrecipe.scheduledevelop.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="user")
public class User extends BaseEntity{

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(){ } //기본생성자

    public User(String username,String email,String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public void updateUser(String username,String email){
        this.username=username;
        this.email=email;
    }
}
//email이 중복된 값이 저장되지못하게 설정
//1 2 3 4 5