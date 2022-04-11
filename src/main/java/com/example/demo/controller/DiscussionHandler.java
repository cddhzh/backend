package com.example.demo.controller;

import com.example.demo.entity.Discussion;
import com.example.demo.repository.DiscussionRepository;
import com.example.demo.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Discussion> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        Page<Discussion> discussionPage = discussionRepository.findAll(pageable);
        for (int i = 0; i < discussionPage.getContent().size(); i++){
            discussionPage.getContent().get(i).setAvatar(userRepository.findAvatar(discussionPage.getContent().get(i).getAuthorID()));
        }
        return discussionPage;
    }
    @GetMapping("/findAllDis")
    public List<Discussion> findAllDis(){
        return discussionRepository.findAll();
    }
    @GetMapping("/findByID/{id}")
    public Discussion findByID(@PathVariable("id") Integer id){
        Discussion discussion = discussionRepository.findById(id).get();
        discussion.setAvatar(userRepository.findAvatar(discussion.getAuthorID()));
        return discussion;
    }
    @GetMapping("/findBySubjectID/{subjectID}/{page}/{size}")
    public Page<Discussion> findBySubjectID(@PathVariable("subjectID") Integer subjectID, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        Page<Discussion> discussionPage = discussionRepository.findBySubjectID(subjectID, pageable);
        for (int i = 0; i < discussionPage.getContent().size(); i++){
            discussionPage.getContent().get(i).setAvatar(userRepository.findAvatar(discussionPage.getContent().get(i).getAuthorID()));
        }
        return discussionPage;
    }
    @PostMapping("/save")
    public Discussion save(@RequestBody Discussion discussion){
        return discussionRepository.save(discussion);
    }
}
