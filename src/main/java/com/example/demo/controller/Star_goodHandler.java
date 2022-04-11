package com.example.demo.controller;

import com.example.demo.entity.Good;
import com.example.demo.entity.Star_good;
import com.example.demo.repository.GoodRepository;
import com.example.demo.repository.Star_goodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/star_good")
public class Star_goodHandler {
    @Autowired
    private Star_goodRepository star_goodRepository;
    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/findById/{goodid}/{userid}")
    public boolean findById(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        Star_good star_good = star_goodRepository.findByGoodidAndUserid(goodid, userid);
        if(star_good != null){
            return true;
        }
        return false;
    }

    @PostMapping("/star/{goodid}/{userid}")
    public Star_good Star(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        Star_good star_good = new Star_good();
        star_good.setUserid(userid);
        star_good.setGoodid(goodid);
        return star_goodRepository.save(star_good);
    }

    @PostMapping("/staroff/{goodid}/{userid}")
    public void Staroff(@PathVariable("goodid") Integer goodid, @PathVariable("userid") Integer userid){
        star_goodRepository.deleteByGoodidAndUserid(goodid, userid);
    }

    @GetMapping("/findgood/{userid}")
    public List<Good> findAllByUid(@PathVariable("userid") Integer userid){
        List<Integer> ids = star_goodRepository.findIdByUserid(userid);
        List<Good> goodList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            goodList.add(goodRepository.findById(ids.get(i)).orElse(null));
        }
        return goodList;
    }
}
