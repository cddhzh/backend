package com.example.demo.controller;

import com.example.demo.entity.Discussion;
import com.example.demo.entity.Thumb_dis;
import com.example.demo.repository.DiscussionRepository;
import com.example.demo.repository.Thumb_disRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/thumb_dis")
public class Thumb_disHandler {
    @Autowired
    private Thumb_disRepository thumb_disRepository;
    @Autowired
    private DiscussionRepository discussionRepository;

    @GetMapping("/findById/{discussionid}/{userid}")
    public boolean findById(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        Thumb_dis thumb_dis = thumb_disRepository.findByDiscussionidAndUserid(discussionid, userid);
        if(thumb_dis != null){
            return true;
        }
        return false;
    }

    @PostMapping("/thumb/{discussionid}/{userid}")
    public Thumb_dis thumb(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        Thumb_dis thumb_dis = new Thumb_dis();
        thumb_dis.setUserid(userid);
        thumb_dis.setDiscussionid(discussionid);
        return thumb_disRepository.save(thumb_dis);
    }

    @PostMapping("/thumboff/{discussionid}/{userid}")
    public void thumboff(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        thumb_disRepository.deleteByDiscussionidAndUserid(discussionid, userid);
    }

    @GetMapping("/findDiscussion/{userid}")
    public List<Discussion> findAllByUid(@PathVariable("userid") Integer userid){
        List<Integer> ids = thumb_disRepository.findIdByUserid(userid);
        List<Discussion> discussionList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            discussionList.add(discussionRepository.findById(ids.get(i)).orElse(null));
        }
        return discussionList;
    }
}
