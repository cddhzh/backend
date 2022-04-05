package com.example.demo.repository;

import com.example.demo.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademyRepository extends JpaRepository<Academy, Integer> {
    public List<Academy> findBySchool(String school);
}
