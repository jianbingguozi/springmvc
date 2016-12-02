package com.jianbingguozi.test.service;

import com.jianbingguozi.bean.User;
import com.jianbingguozi.service.inter.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public class ServiceTest {
    ApplicationContext context = null;
    UserService userService = null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        userService = context.getBean(UserService.class);
    }

    @Test
    public void startSpring(){
        //加载spring bean工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.speak();
    }

    @Test
    public void userServiceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.findById(3);
        System.out.println(user);
    }

    @Test
    public void userServiceInsertNT(){
        User user = new User();
        user.setName("蟑螂");
        user.setAge(1);
        userService.registUser(user);

        System.out.println(user);
    }
}
