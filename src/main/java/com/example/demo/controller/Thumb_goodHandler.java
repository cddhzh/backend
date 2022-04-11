package com.example.demo.controller;

import com.example.demo.entity.Good;
import com.example.demo.entity.Thumb_good;
import com.example.demo.repository.GoodRepository;
import com.example.demo.repository.Thumb_goodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/thumb_good")
public class Thumb_goodHandler {
    @Autowired
    private Thumb_goodRepository thumb_goodRepository;
    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/findById/{goodid}/{userid}")
    public boolean findById(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        Thumb_good thumb_good = thumb_goodRepository.findByGoodidAndUserid(goodid, userid);
        if(thumb_good != null){
            return true;
        }
        return false;
    }

    @PostMapping("/thumb/{goodid}/{userid}")
    public Thumb_good thumb(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        Thumb_good thumb_good = new Thumb_good();
        thumb_good.setUserid(userid);
        thumb_good.setGoodid(goodid);
        return thumb_goodRepository.save(thumb_good);
    }

    @PostMapping("/thumboff/{goodid}/{userid}")
    public void thumboff(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        thumb_goodRepository.deleteByGoodidAndUserid(goodid, userid);
    }

    @GetMapping("/findgood/{userid}")
    public List<Good> findAllByUid(@PathVariable("userid") Integer userid){
        List<Integer> ids = thumb_goodRepository.findIdByUserid(userid);
        List<Good> goodList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            goodList.add(goodRepository.findById(ids.get(i)).orElse(null));
        }
        return goodList;
    }
}
