package com.jianbingguozi.test.dao;

import com.jianbingguozi.bean.User;
import com.jianbingguozi.dao.UserDao;
import com.jianbingguozi.test.bean.ResourceIocTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public class BaseDaoTest {
    @Test
    public void testSelect(){
        InputStream resourceAsStream = BaseDaoTest.class.getClassLoader().getResourceAsStream("test/config/mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectById(3);
        System.out.println(user);
    }

    /**
     * 使用spring加载资源文件
     */
    @Test
    public void springDaoTest(){
        //加载spring
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        //构建mybatis.sqlsession
        InputStream stream = BaseDaoTest.class.getClassLoader().getResourceAsStream("test/config/mybatis-config-spring.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = build.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectById(3);
        System.out.println(user);
    }

    /**
     * spring+mybatis整合后
     */
    @Test
    public void testSpringMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.selectById(3);
        System.out.println(user);
    }

    @Test
    public void testResourceIoc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        ResourceIocTest bean = context.getBean(ResourceIocTest.class);
        System.out.println(bean.getName());
    }
}
