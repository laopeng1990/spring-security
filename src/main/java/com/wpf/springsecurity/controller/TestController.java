package com.wpf.springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenpengfei on 2017/3/24.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        return "haha";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public String role1() {
        return "user:" + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping(value = "/admin")
    @ResponseBody
    public String role2() {
        return "admin";
    }
}
