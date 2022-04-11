package com.example.demo.repository;

import com.example.demo.entity.Discussion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Thumb_disRepositoryTest {
    @Autowired
    private Thumb_disRepository thumb_disRepository;
    @Autowired
    private DiscussionRepository discussionRepository;

    @Test
    void findIdByUserid(){
        List<Integer> ids = thumb_disRepository.findIdByUserid(2);
        List<Discussion> discussionList = new ArrayList<>();
        for(int i = 0; i < ids.size(); i++){
            discussionList.add(discussionRepository.findById(ids.get(i)).orElse(null));
        }
        System.out.println(discussionList.get(1).getTitle());
    }
}