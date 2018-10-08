package com.example.springtrac.dao;

import com.example.springtrac.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUser(Integer id);

    Integer insert(User user);

    Integer updateUser(User user);
}
