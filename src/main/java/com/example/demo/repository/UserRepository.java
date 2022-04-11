package com.example.demo.repository;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByName(String name);
    @Query("select phone from User ")
    public List<String> findAllPhone();
    @Query("select account from User ")
    public List<String> findAllAccount();
    @Query("select stuID from User")
    public List<String> findALlStuID();
    @Query(value = "SELECT id,account,phone,password,name,school,academy,major,stuID,avatar from user where account=?1", nativeQuery = true)
    public User find(String account);
    @Query(value = "SELECT avatar from user where account=?1", nativeQuery = true)
    public String findAvatar(String account);
    @Query(value = "SELECT avatar from user where id=?1", nativeQuery = true)
    public String findAvatarById(Integer id);
}
