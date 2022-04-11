package com.example.demo.repository;

import com.example.demo.entity.Good_reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Good_replyRepository extends JpaRepository<Good_reply, Integer> {
    public List<Good_reply> findByGoodid(Integer goodid);
}
