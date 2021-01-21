package com.zhang.zc.web;

import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.web
 * @date:2021/1/21
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(User user){
        AjaxMessage message = new AjaxMessage();
        User user1=userService.query4login(user);
      if(user1 !=null){
          message.setSuccess(true);

      }else {
          message.setSuccess(false);
      }
        return message;

    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
