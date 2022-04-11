package com.example.demo.controller;

import com.example.demo.entity.Good_reply;
import com.example.demo.repository.Good_replyRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good_reply")
public class Good_replyHandler {
    @Autowired
    private Good_replyRepository good_replyRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<Good_reply> findAll(){
        return good_replyRepository.findAll();
    }
    @GetMapping("/findByGoodid/{goodid}")
    public List<Good_reply> findByGoodid(@PathVariable("goodid") Integer id){
        List<Good_reply> replies = good_replyRepository.findByGoodid(id);
        for (int i = 0; i < replies.size(); i++){
            replies.get(i).setAvatar(userRepository.findAvatar(replies.get(i).getAuthorid()));
        }
        return replies;
    }
    @PostMapping("/save")
    public Good_reply save(@RequestBody Good_reply reply){
        return good_replyRepository.save(reply);
    }
}
