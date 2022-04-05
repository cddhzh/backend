package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/find")
    public User login(User user){
        String name=user.getAccount();
        User user1=userRepository.find(name);
        if(user1==null) return null;
        String password=user.getPassword();
        if(password.equals(user1.getPassword())){
            user1.setToken(JwtUtil.createtoken());
            return user1;
        }else{
            return null;
        }
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }
//    @GetMapping("/deleteById")
//    public void deleteById(String account) {
//        userRepository.deleteById(account);
//    }
    @GetMapping("/updateUser")
    public User updateUser(User user){
        return userRepository.save(user);
    }
//    @GetMapping("/findById/{id}")
//    public User findById(@PathVariable("id") String id){
//        return userRepository.findById(id).get();
//    }
//    public List<User> findByName(){
//        return userRepository.findByName()
//    }
    @GetMapping("/findAllPhone")
    public List<String> findAllPhone(){
        return userRepository.findAllPhone();
    }
    @GetMapping("/findAllAccount")
    public List<String> findAllAccount(){
        return userRepository.findAllAccount();
    }
    @GetMapping("/findAllStuID")
    public List<String> findAllStuID(){
        return userRepository.findALlStuID();
    }
    @GetMapping("/checkToken")
    public boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return JwtUtil.checkToken(token);
    }
}
