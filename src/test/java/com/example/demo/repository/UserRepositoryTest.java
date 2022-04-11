package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll(){
        System.out.println(userRepository.findAll());
    }

    @Test
    void save(){
        User user = new User();
        user.setAccount("18159556501");
        user.setPhone("18159556501");
        user.setName("hzh");
        user.setMajor("computer");
        user.setSchool("上海理工大学");
        user.setStuID("1935031215");
        user.setPassword("123456");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

    @Test
    void find(){
//        User user = new User();
//        user.setAccount("cdd");
//        user.setPassword("123456");
        User user = userRepository.find("cdd");
        System.out.println(user);
    }

    @Test
    void findByName(){
        String a = "hzh";
        List<User> users = userRepository.findByName(a);
        System.out.println(users);
    }

    @Test
    void findAllPhone(){
        List<String> phones = userRepository.findAllPhone();
        System.out.println(phones);
    }

    @Test
    void findAvatars(){
        List<String> uids = new ArrayList<>();
        List<String> avatars = new ArrayList<>();
        uids.add("cdd");
        uids.add("hzh");
        uids.add("cdd");
        for (int i = 0; i < uids.size(); i++){
            avatars.add(userRepository.findAvatar(uids.get(i)));
        }
        System.out.println(avatars);
    }

    @Test
    void findALlByPage(){

    }
}