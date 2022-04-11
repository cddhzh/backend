package com.example.demo.controller;

import com.example.demo.entity.Reply;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyHandler {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<Reply> findAll(){
        return replyRepository.findAll();
    }
    @GetMapping("/findByDiscussionid/{discussionid}")
    public List<Reply> findByDiscussionid(@PathVariable("discussionid") Integer id){
        List<Reply> replies = replyRepository.findByDiscussionid(id);
        for (int i = 0; i < replies.size(); i++){
            replies.get(i).setAvatar(userRepository.findAvatar(replies.get(i).getAuthorID()));
        }
        return replies;
    }
    @PostMapping("/save")
    public Reply save(@RequestBody Reply reply){
        return replyRepository.save(reply);
    }
}
