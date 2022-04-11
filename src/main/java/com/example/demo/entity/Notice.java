package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String url;

    private Date time;

    private String school;

    private Integer visit_num;

    private String cover;
}
