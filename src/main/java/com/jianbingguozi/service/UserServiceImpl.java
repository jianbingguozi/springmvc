package com.jianbingguozi.service;

import com.jianbingguozi.bean.User;
import com.jianbingguozi.dao.UserDao;
import com.jianbingguozi.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void speak(){
        System.out.println("hello");
    }

    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    public void registUser(User user) {
        userDao.insertUser(user);
    }
}
