package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;
    @Test
    void findAll(){
        System.out.println(activityRepository.findAll());
    }
}