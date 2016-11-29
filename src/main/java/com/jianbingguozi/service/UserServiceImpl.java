package com.jianbingguozi.service;

import com.jianbingguozi.service.inter.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    public void speak(){
        System.out.println("hello");
    }
}
