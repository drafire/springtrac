package com.example.springtrac.service;

import com.example.springtrac.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

//这里使用这两个注解就可以了
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfo() throws Exception{
        User user = userService.getUserInfo(1);
    }

    @Test
    public void doTransfer() throws Exception {
        userService.doTransfer(1,2, new BigDecimal(30));
    }
}