package com.jianbingguozi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jianb on 2016/11/29.
 * @Description TODO
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(Model model){
        log.debug("======================");
        return "login";
    }

    @RequestMapping("/test")
    public void test(){
        log.debug("--------=-=-=-=-=-=--=----------------");
    }
}
