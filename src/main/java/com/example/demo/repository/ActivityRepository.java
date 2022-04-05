package com.example.demo.repository;

import com.example.demo.entity.Activity;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Activity o SET o.state=:status where o.join_end<:now ")
    void updateover(@Param("status")String status, @Param("now") Date now);

    @Transactional
    @Modifying
    @Query("UPDATE Activity o SET o.state=:status where o.join_start>:now ")
    int updatewait(@Param("status")String status, @Param("now")Date now);

    @Transactional
    @Modifying
    @Query("UPDATE Activity o SET o.state=:status where o.join_start<:now and o.join_end>:now")
    int updatejoin(@Param("status")String status, @Param("now")Date now);

    public Page findByState(String state, Pageable pageable);

    public Page findByStateAndSchool(String state, Pageable pageable,String school);

    public Page findBySchool(Pageable pageable,String school);

    public List findByPostname(String post_name);

    public Page findByIdIn(Pageable pageable,List<Integer> Id);


}

