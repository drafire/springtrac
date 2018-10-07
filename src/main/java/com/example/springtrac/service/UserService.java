package com.example.springtrac.service;

import com.example.springtrac.dao.UserDao;
import com.example.springtrac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserInfo(Integer id) {
        return userDao.query(id);
    }

   public void test(){
       System.out.println("123");
   }
}
