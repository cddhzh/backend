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
        List<Good> goodList = goodRepository.findAll();
        for (int i = 0; i < goodList.size(); i++){
            goodList.get(i).setImgUrls(goodList.get(i).getImgUrls(goodList.get(i).getGoodimgs()));
        }
        return goodList;
    }

    @PostMapping("/save")
    public Good save(@RequestBody Good good){
        return goodRepository.save(good);
    }

    @GetMapping("/findById/{goodid}")
    public Good findById(@PathVariable("goodid") Integer id){
        Good good = goodRepository.findById(id).orElse(null);
        if(good != null){
            good.setImgUrls(good.getImgUrls(good.getGoodimgs()));
        }
        return good;
    }

}
