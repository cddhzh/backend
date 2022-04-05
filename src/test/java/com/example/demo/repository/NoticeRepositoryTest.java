package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeRepositoryTest {
    @Autowired
    private NoticeRepository noticeRepository;
    @Test
    void findBySchool(){
        Pageable pageable = PageRequest.of(0,3);
        System.out.println(noticeRepository.findBySchool("上海师范大学", pageable));
    }
}