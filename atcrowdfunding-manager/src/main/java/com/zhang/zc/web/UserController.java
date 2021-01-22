package com.zhang.zc.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String user1(/*@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,
                        @RequestParam(value = "pageSize",defaultValue = "2")Integer pageSize , Model model*/){
       /* PageHelper.startPage(pageNumber,pageSize);
         List<User> userList=userService.pageQuery();
        PageInfo<User> pageInfo=new PageInfo<User>(userList,3);
        model.addAttribute("pageInfo",pageInfo);*/
        return "user/index";
    }

    @RequestMapping("/pages")
    @ResponseBody
    public Object pages(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "2")Integer pageSize,
                        @RequestParam(value = "username")String username){
            AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            Map<String,String> map=new HashMap<String, String>();
            map.put("username",username);
            PageHelper.startPage(pageNum,pageSize);
            List<User> userList=userService.pageQuery(map);
            PageInfo<User> pageInfo=new PageInfo<User>(userList,3);
            ajaxMessage.setSuccess(true);
            ajaxMessage.setData(pageInfo);

        } catch (Exception e) {
            ajaxMessage.setSuccess(false);
            e.printStackTrace();
        }

        return ajaxMessage;

    }
}
