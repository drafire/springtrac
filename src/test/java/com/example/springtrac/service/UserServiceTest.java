package com.example.springtrac.service;

import com.example.springtrac.UserService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnit4.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService1 userService1;

    @Test
    public void getUserInfo() {
//        User user = userService.getUserInfo(1);
////        System.out.println(user.toString());
        //userService.test();
        userService1.say();
    }
}