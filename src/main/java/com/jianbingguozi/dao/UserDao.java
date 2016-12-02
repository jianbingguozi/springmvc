package com.jianbingguozi.dao;

import com.jianbingguozi.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public interface UserDao {

    @Select("select * from users where id = #{id}")
    public abstract User selectById(Integer id);

    @Insert("INSERT INTO users(name, age) VALUES (#{user.name},#{user.age});")
    @Options(keyProperty = "user.id", useGeneratedKeys = true)
    public abstract void insertUser(@Param("user") User user);
}
