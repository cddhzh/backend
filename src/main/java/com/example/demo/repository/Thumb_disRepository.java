package com.example.demo.repository;

import com.example.demo.entity.Thumb_dis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Thumb_disRepository extends JpaRepository<Thumb_dis, Integer> {
    public Thumb_dis findByDiscussionidAndUserid(Integer discussionid, Integer userid);
    @Transactional
    public void deleteByDiscussionidAndUserid(Integer discussionid, Integer userid);
    @Query(value = "SELECT discussionid from thumb_dis where userid=?1", nativeQuery = true)
    public List<Integer> findIdByUserid(Integer userid);
}
