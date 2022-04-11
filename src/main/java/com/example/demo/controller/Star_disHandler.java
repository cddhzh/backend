package com.example.demo.controller;

import com.example.demo.entity.Discussion;
import com.example.demo.entity.Star_dis;
import com.example.demo.repository.DiscussionRepository;
import com.example.demo.repository.Star_disRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/star_dis")
public class Star_disHandler {
    @Autowired
    private Star_disRepository star_disRepository;
    @Autowired
    private DiscussionRepository discussionRepository;

    @GetMapping("/findById/{discussionid}/{userid}")
    public boolean findById(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        Star_dis star_dis = star_disRepository.findByDiscussionidAndUserid(discussionid, userid);
        if(star_dis != null){
            return true;
        }
        return false;
    }

    @PostMapping("/star/{discussionid}/{userid}")
    public Star_dis Star(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        Star_dis star_dis = new Star_dis();
        star_dis.setUserid(userid);
        star_dis.setDiscussionid(discussionid);
        return star_disRepository.save(star_dis);
    }

    @PostMapping("/staroff/{discussionid}/{userid}")
    public void Staroff(@PathVariable("discussionid") Integer discussionid, @PathVariable("userid") Integer userid){
        star_disRepository.deleteByDiscussionidAndUserid(discussionid, userid);
    }

    @GetMapping("/findDiscussion/{userid}")
    public List<Discussion> findAllByUid(@PathVariable("userid") Integer userid){
        List<Integer> ids = star_disRepository.findIdByUserid(userid);
        List<Discussion> discussionList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            discussionList.add(discussionRepository.findById(ids.get(i)).orElse(null));
        }
        return discussionList;
    }
}
