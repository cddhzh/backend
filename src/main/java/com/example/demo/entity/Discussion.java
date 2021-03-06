package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer subjectID;
    String title;
    String content;
    String authorID;
    Date time;
    @Transient
    String avatar;
}
