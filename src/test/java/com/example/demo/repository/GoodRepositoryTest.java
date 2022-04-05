package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodRepositoryTest {
    @Autowired
    private GoodRepository goodRepository;

    @Test
    public void findAll(){
        System.out.println(goodRepository.findAll());
    }
}