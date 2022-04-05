package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Good {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;
    String goodname;
    String description;
    float price;
    String ownerid;
    String url;
    Date time;
}
