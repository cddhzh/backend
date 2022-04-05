package com.example.demo.repository;

import com.example.demo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
