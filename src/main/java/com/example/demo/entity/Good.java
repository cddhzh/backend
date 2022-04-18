package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Good {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;
    String goodname;
    String description;
    String price;
    String ownerid;
    String url;
    Date time;
    String goodimgs;
    @Transient
    List<String> imgUrls;

    public List<String> getImgUrls(String goodimgs) {
        if(goodimgs != null){
            imgUrls = List.of(goodimgs.split(" "));
        }
        return imgUrls;
    }
}
