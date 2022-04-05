package com.example.demo.controller;

import com.example.demo.entity.Reply;
import com.example.demo.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyHandler {
    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("/findAll")
    public List<Reply> findAll(){
        return replyRepository.findAll();
    }
    @GetMapping("/findByDiscussionid/{discussionid}")
    public List<Reply> findByDiscussionid(@PathVariable("discussionid") Integer id){
        return replyRepository.findByDiscussionid(id);
    }
    @PostMapping("/save")
    public Reply save(@RequestBody Reply reply){
        return replyRepository.save(reply);
    }
}
