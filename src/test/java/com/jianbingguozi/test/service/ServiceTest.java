package com.jianbingguozi.test.service;

import com.jianbingguozi.service.inter.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
public class ServiceTest {
    @Test
    public void startSpring(){
        //加载spring bean工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.speak();
    }
}
