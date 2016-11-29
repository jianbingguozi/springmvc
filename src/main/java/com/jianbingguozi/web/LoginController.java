package com.jianbingguozi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(Model model){
        System.out.println("======================");
        return "login";
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("--------=-=-=-=-=-=--=----------------");
    }
}
