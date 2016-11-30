package com.jianbingguozi.test.dao;

import com.jianbingguozi.bean.User;
import com.jianbingguozi.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public class BaseDaoTest {
    @Test
    public void testSelect(){
        InputStream resourceAsStream = BaseDaoTest.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectById(3);
        System.out.println(user);
    }
}
