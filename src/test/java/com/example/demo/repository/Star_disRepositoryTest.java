package com.example.demo.repository;

import com.example.demo.entity.Star_dis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Transient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Star_disRepositoryTest {
    @Autowired
    private Star_disRepository star_disRepository;

    @Test
    void findById(){
        Star_dis star_dis = new Star_dis();
        star_dis = star_disRepository.findByDiscussionidAndUserid(2, 3);
        System.out.println(star_dis);
    }

    @Test
    void Star(){
        Star_dis star_dis = new Star_dis();
        star_dis.setDiscussionid(2);
        star_dis.setUserid(2);
        System.out.println(star_disRepository.save(star_dis));
    }

    @Test
    void Staroff(){
        star_disRepository.deleteByDiscussionidAndUserid(2,2);
    }

    @Test
    void findIdByUserId(){
        System.out.println(star_disRepository.findIdByUserid(2));;
    }
}