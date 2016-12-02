package com.jianbingguozi.service.inter;

import com.jianbingguozi.bean.User;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public interface UserService {
    public abstract void speak();
    public abstract User findById(Integer id);
}
