package com.example.demo.repository;

import com.example.demo.entity.Discussion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    public Page<Discussion> findBySubjectID(Integer subjectID, Pageable pageable);
}
