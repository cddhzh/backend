package com.example.demo.controller;

import com.example.demo.entity.Academy;
import com.example.demo.repository.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academy")
public class AcademyHandler {
    @Autowired
    private AcademyRepository academyRepository;

    @GetMapping("/findBySchool/{school}")
    public List<Academy> findBySchool(@PathVariable("school") String school){
        return academyRepository.findBySchool(school);
    }
}
