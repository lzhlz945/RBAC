package com.zhang.zc.web;

import com.zhang.zc.bean.User;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String user1(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,
                        @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize , Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageStart",(pageNumber-1)*pageSize);
        map.put("pageSize",pageSize);
         List<User> userList=userService.pageQuery(map);
         model.addAttribute("uList",userList);
        return "user/index";
    }
}
