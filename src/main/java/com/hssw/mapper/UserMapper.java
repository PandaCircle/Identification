package com.hssw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hssw.model.*;

public interface UserMapper{
    @Select("SELECT * FROM users")
    @Results({
        @Result(property = "nickName", column = "nickname"),
        @Result(property = "userName" ,column = "username")
    })
    List<UserEntity> getAll();

    @Insert("INSERT INTO users(nickname,password,username) VALUES(#{nickName},#{password},#{userName})")
    void insert(UserEntity user);

    @Select("SELECT * FROM users WHERE username = #{userName}")
    UserEntity getUserByUserName(String userName);

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserEntity getUserById(int id);
}