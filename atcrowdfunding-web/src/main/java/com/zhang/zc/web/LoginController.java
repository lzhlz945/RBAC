package com.zhang.zc.web;

import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.Permission;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.PermissionService;
import com.zhang.zc.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.web
 * @date:2021/1/21
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    //跳转登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    //登录
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(User user, HttpSession session){
        AjaxMessage message = new AjaxMessage();
        User user1=userService.query4login(user);
        Map<Integer,Permission> map=new HashMap<>();
        List<Permission> permissions=permissionService.queryUserPermission(user1);
        Set<String> userSet=new HashSet<>();
        for (Permission permission : permissions) {
            if(permission.getPid()!=null || !"".equals(permission.getPid())){

            map.put(permission.getId(),permission);
            }
            if(permission.getUrl() != null || !"".equals(permission.getUrl())){

            userSet.add(session.getServletContext().getContextPath()+permission.getUrl());
            }
        }
        session.setAttribute("userPermission",userSet);
        Permission rootPermissions= null;
        for (Permission permission : permissions) {
            Permission children=permission;
            if(children.getPid() == 0){
                rootPermissions=permission;
            }else {
                if(permission.getPid()!=null || !"".equals(permission.getPid())){

                Permission parent=map.get(children.getPid());
                parent.getChildren().add(children);
                }
            }
        }
        session.setAttribute("permissionRoot",rootPermissions);

      if(user1 !=null){
          message.setSuccess(true);
          session.setAttribute("user",user1);

      }else {
          message.setSuccess(false);
      }
        return message;

    }
    //登录成功
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    //登出

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/toLogin";
    }

    @RequestMapping("/error")
    public String error1(HttpSession session){
       User user= (User)session.getAttribute("user");

       session.setAttribute("message",user.getUsername());
        return "user/error";
    }
}
