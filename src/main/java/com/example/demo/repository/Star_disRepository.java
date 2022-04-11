package com.example.demo.repository;

import com.example.demo.entity.Star_dis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface Star_disRepository extends JpaRepository<Star_dis, Integer> {
    public Star_dis findByDiscussionidAndUserid(Integer discussionid, Integer userid);
    @Transactional
    public void deleteByDiscussionidAndUserid(Integer discussionid, Integer userid);
    @Query(value = "SELECT discussionid from star_dis where userid=?1", nativeQuery = true)
    public List<Integer> findIdByUserid(Integer userid);
}
