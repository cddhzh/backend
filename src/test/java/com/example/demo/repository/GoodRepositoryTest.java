package com.example.demo.repository;

import com.example.demo.entity.Good;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodRepositoryTest {
    @Autowired
    private GoodRepository goodRepository;

    @Test
    public void findAll(){
        List<Good> goodList = goodRepository.findAll();
        for (int i = 0; i < goodList.size(); i++){
            goodList.get(i).setImgUrls(goodList.get(i).getImgUrls(goodList.get(i).getGoodimgs()));
        }
        System.out.println(goodList);
    }
}