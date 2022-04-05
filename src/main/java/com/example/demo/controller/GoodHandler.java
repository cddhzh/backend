package com.example.demo.controller;

import com.example.demo.entity.Good;
import com.example.demo.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodHandler {
    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/findAll")
    public List<Good> findAll(){
        return goodRepository.findAll();
    }
    @PostMapping("/save")
    public Good save(@RequestBody Good good){
        return goodRepository.save(good);
    }
}
