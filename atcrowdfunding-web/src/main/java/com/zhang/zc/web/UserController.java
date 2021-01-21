package com.zhang.zc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.web
 * @date:2021/1/21
 */

@Controller
public class UserController {


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
