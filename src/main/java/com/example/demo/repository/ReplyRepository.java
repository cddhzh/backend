package com.example.demo.repository;

import com.example.demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    public List<Reply> findByDiscussionid(Integer discussionid);
}
