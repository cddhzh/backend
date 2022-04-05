package com.example.demo.repository;

import com.example.demo.entity.Discussion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscussionRepositoryTest {
    @Autowired
    private DiscussionRepository discussionRepository;

    @Test
    void findAll(){
        System.out.println(discussionRepository.findAll());
    }

    @Test
    void findBySubjectID(){
        Integer subjectId = 1;
        Pageable pageable =  PageRequest.of(1, 6);
        System.out.println(discussionRepository.findBySubjectID(subjectId, pageable));
    }

    @Test
    void save(){
        Discussion discussion = new Discussion();
        discussion.setSubjectID(1);
        discussion.setTitle("test6");
        discussion.setContent("test test test");
        discussion.setAuthorID("15960686139");
        discussion.setTime(new Date());
        Discussion discussion1 = discussionRepository.save(discussion);
        System.out.println(discussion1);
    }
}