package com.jianbingguozi.dao;

import com.jianbingguozi.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public interface UserDao {

    @Select("select * from users where id = #{id}")
    public abstract User selectById(Integer id);
}
