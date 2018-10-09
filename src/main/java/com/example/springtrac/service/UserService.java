package com.example.springtrac.service;

import com.example.springtrac.dao.UserDao;
import com.example.springtrac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserInfo(Integer id) throws Exception {
        User user = userDao.getUser(id);
        if (user == null) {
            throw new Exception("不存在该用户");
        }
        return user;
    }

    //@Transactional
    public void income(int incomeId, BigDecimal amout) throws Exception {
        User user = getUserInfo(incomeId);
        user.setAmout(user.getAmout().add(amout));
        userDao.updateUser(user);
        //这里抛出父异常类型，不能回滚
        //throw new Exception("转入失败");
        //事务只捕捉运行时的异常，这里抛出运行时异常，成功回滚
        throw new RuntimeException("转入失败");
    }

    //@Transactional
    public void outcome(int outcomeId, BigDecimal amout) throws Exception {
        User user = getUserInfo(outcomeId);
        if (user.getAmout().compareTo(amout) < 0) {
            throw new Exception("账户余额不足");
        }
        user.setAmout(user.getAmout().subtract(amout));
        user.setAmout(user.getAmout().subtract(amout));
    }

    //默认的事务传播行为，就是Propagation.REQUIRED
    @Transactional(propagation = Propagation.REQUIRED)
    public void doTransfer(int incomeId, int outcomeId, BigDecimal amout) throws Exception {
        outcome(outcomeId, amout);
        income(incomeId, amout);
    }
}
