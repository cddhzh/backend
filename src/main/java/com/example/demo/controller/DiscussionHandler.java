package com.example.demo.controller;

import com.example.demo.entity.Discussion;
import com.example.demo.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discussion")
public class DiscussionHandler {
    @Autowired
    private DiscussionRepository discussionRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Discussion> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return discussionRepository.findAll(pageable);
    }
    @GetMapping("/findByID/{id}")
    public Discussion findByID(@PathVariable("id") Integer id){
        return discussionRepository.findById(id).get();
    }
    @GetMapping("/findBySubjectID/{subjectID}/{page}/{size}")
    public Page<Discussion> findBySubjectID(@PathVariable("subjectID") Integer subjectID, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return discussionRepository.findBySubjectID(subjectID, pageable);
    }
    @PostMapping("/save")
    public Discussion save(@RequestBody Discussion discussion){
        return discussionRepository.save(discussion);
    }
}
