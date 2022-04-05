package com.example.demo.repository;

import com.example.demo.entity.Actuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActuserRepository extends JpaRepository<Actuser,Integer> {
    public List findByActidAndUid(Integer Actid,Integer Uid);
    @Query("select actid from Actuser where uid=?1")
    public List<Integer> findaidByUid(Integer Uid);
}
