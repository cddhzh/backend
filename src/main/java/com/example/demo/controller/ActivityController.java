package com.example.demo.controller;


import com.example.demo.entity.Activity;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.ActuserRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActuserRepository actuserRepository;

    @GetMapping("/findByUser/{uid}/{page}/{size}")
    public Page<Activity> findByUser(@PathVariable("uid") Integer uid,
                                     @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        List<Integer> actuserList=actuserRepository.findaidByUid(uid);
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return activityRepository.findByIdIn(pageable,actuserList);

    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Activity> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Date date = new Date();
        long times = date.getTime();
        Date now = new Date(times);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String now=simpleDateFormat.format(date);
        activityRepository.updateover("已结束",now);
        activityRepository.updatewait("规划中",now);
        activityRepository.updatejoin("报名中",now);
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return activityRepository.findAll(pageable);
    }

    @GetMapping("/findAll/{page}/{size}/{range}/{state}")
    public Page<Activity> findById(@PathVariable("page") Integer page, @PathVariable("size") Integer size,
                                   @PathVariable("range") String range, @PathVariable("state") String state){
        System.out.println(range+state);
        if(range==null&&state==null||range.equals("*")&&state==null){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findAll(pageable);
        }
        else if(range==null&&state=="*"||range.equals("*")&&state.equals("*")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findAll(pageable);
        }
        else if(range!=null&&state=="*"||range!="*"&&state.equals("*")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findBySchool(pageable,range);
        }
        else if(range.equals("*")&&state.equals("已结束")||range==null&&state.equals("已结束")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByState("已结束",pageable);
        }
        else if(range.equals("*")&&state.equals("报名中")||range==null&&state.equals("报名中")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByState("报名中",pageable);
        }
        else if(range.equals("*")&&state.equals("规划中")||range==null&&state.equals("规划中")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByState("规划中",pageable);
        }
        else if(range!="*"&&state==null){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findBySchool(pageable,range);
        }
        else if(range!="*"&&state.equals("规划中")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByStateAndSchool("规划中",pageable,range);
        }
        else if(range!="*"&&state.equals("已结束")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByStateAndSchool("已结束",pageable,range);
        }
        else if(range!="*"&&state.equals("报名中")){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(page-1,size,sort);
            return activityRepository.findByStateAndSchool("报名中",pageable,range);
        }
        else{
            return null;
        }
    }


    @GetMapping("/findById/{id}")
    public Activity findById(@PathVariable("id") Integer id){
        return activityRepository.findById(id).get();
    }

    @GetMapping("/findCreate/{id}")
    public List findByCreate(@PathVariable("id") String id){
        return activityRepository.findByPostname(id);
    }


    @GetMapping("/addAct/{title}/{content}/{uname}/{loc}/{range}/{amount}/{acttype}/{js}/{je}/{as}/{ae}")
    public String addAct(@PathVariable("title") String title, @PathVariable("content") String content,
                         @PathVariable("uname") String uname, @PathVariable("range") String range,
                         @PathVariable("amount") Integer amount,
                         @PathVariable("acttype") String acttype, @PathVariable("loc") String location,
                         @PathVariable("js") Date js,@PathVariable("je") Date je,
                         @PathVariable("as") Date as,@PathVariable("ae") Date ae){
//        System.out.println(title+content+uname+time);
        Activity activity = new Activity();
        activity.setAmount(0);
        activity.setTitle(title);
        activity.setContent(content);
        activity.setPostname(uname);
        activity.setAct_start(as);
        activity.setAct_end(ae);
        activity.setJoin_start(js);
        activity.setJoin_end(je);
        activity.setSchool(range);
        activity.setLocation(location);
        activity.setMax_amount(amount);
        activity.setType(acttype);
        System.out.println(activity);
        Activity result=activityRepository.save(activity);
        if(result!=null){
            return "success";
        }else{
            return "false";
        }
    }



}
