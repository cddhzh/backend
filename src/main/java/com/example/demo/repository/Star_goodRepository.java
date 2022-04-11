package com.example.demo.repository;

import com.example.demo.entity.Star_good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Star_goodRepository extends JpaRepository<Star_good, Integer> {
    public Star_good findByGoodidAndUserid(Integer goodid, Integer userid);
    @Transactional
    public void deleteByGoodidAndUserid(Integer goodid, Integer userid);
    @Query(value = "SELECT goodid from star_dis where userid=?1", nativeQuery = true)
    public List<Integer> findIdByUserid(Integer userid);
}
