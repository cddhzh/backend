package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectHandler {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/findAll")
    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }
}
