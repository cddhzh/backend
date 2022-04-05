package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void findAll(){
        System.out.println(replyRepository.findAll());
    }
    @Test
    public void findByDiscussionid(){
        Integer id=1;
        System.out.println(replyRepository.findByDiscussionid(id));
    }
}