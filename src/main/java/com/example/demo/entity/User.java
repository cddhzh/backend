package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String account;
    private String phone;
    private String password;
    private String name;
    private String stuID;
    private String school;
    private String major;
    private String academy;
    @Transient
    private String token;
}
