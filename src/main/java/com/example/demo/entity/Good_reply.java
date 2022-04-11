package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Good_reply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;
    Integer goodid;
    String authorid;
    String content;
    Date time;
    @Transient
    String avatar;
}
