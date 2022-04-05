package com.example.demo.controller;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolHandler {
    @Autowired
    private SchoolRepository schoolrepository;

    @GetMapping("/findAll")
    public List<School> findAll(){
        return schoolrepository.findAll();
    }
}
