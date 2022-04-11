package com.example.demo.repository;

import com.example.demo.entity.Thumb_good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Thumb_goodRepository extends JpaRepository<Thumb_good, Integer> {
    public Thumb_good findByGoodidAndUserid(Integer goodid, Integer userid);
    @Transactional
    public void deleteByGoodidAndUserid(Integer goodid, Integer userid);
    @Query(value = "SELECT goodid from star_dis where userid=?1", nativeQuery = true)
    public List<Integer> findIdByUserid(Integer userid);
}
