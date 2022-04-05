package com.example.demo.controller;

import com.example.demo.entity.Activity;
import com.example.demo.entity.Actuser;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.ActuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actuser")
public class ActuserController {
    @Autowired
    private ActuserRepository actuserRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/findByUidAndActId/{uid}/{actid}")
    public String findByUidAndActId(@PathVariable("uid") Integer uid, @PathVariable("actid")Integer actId){
        if(actuserRepository.findByActidAndUid(actId,uid).size()==0) return "不存在";
        if(actuserRepository.findByActidAndUid(actId,uid).get(0)!=null) return "存在";
        return null;
    }

    @GetMapping("/join/{uid}/{actid}")
    public String join(@PathVariable("uid") Integer uid, @PathVariable("actid")Integer actId, Activity activity){
        Actuser actuser=new Actuser();
        actuser.setActid(actId);
        actuser.setUid(uid);
//        System.out.println(actuser);
        Integer amount=activity.getAmount();
        amount+=1;
        activity.setAmount(amount);
        activityRepository.save(activity);
        Actuser result=actuserRepository.save(actuser);
        if(result!=null){
            return "success";
        }else{
            return "false";
        }
    }

    @GetMapping("/quit/{uid}/{actid}")
    public void quit(@PathVariable("uid") Integer uid, @PathVariable("actid")Integer actId, Activity activity){
        Actuser actuser=new Actuser();
        actuser.setActid(actId);
        actuser.setUid(uid);
        System.out.println(actuser);
        List<Actuser> actuser1=actuserRepository.findByActidAndUid(actId,uid);
        Integer id=actuser1.get(0).getId();
//        System.out.println(id);
        Integer amount=activity.getAmount();
        amount-=1;
        activity.setAmount(amount);
        activityRepository.save(activity);
        actuserRepository.deleteById(id);
//        Actuser result=actuserRepository.deleteById(actuser);
//        if(result!=null){
//            return "success";
//        }else{
//            return "false";
//        }
    }
}
