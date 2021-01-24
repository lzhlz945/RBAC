package com.zhang.zc.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
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

    //跳转新增
    @RequestMapping("/add")
    public String add(){

        return "user/add";
    }

    //新增

    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(User user){
        AjaxMessage ajaxMessage = new AjaxMessage();
        int a=userService.insert(user);
        if(a>0){
            ajaxMessage.setSuccess(true);

        }else {
            ajaxMessage.setSuccess(false);
        }

        return ajaxMessage;

    }

    //跳转至单个修改
    @RequestMapping("/toEdit")
    public String toEdit(String userId, Model model){
        Integer integer = Integer.valueOf(userId);
        User user=  userService.selectOne(integer);
        model.addAttribute("user1",user);
        return "user/edit";
    }

    //修改前检查账户
    @RequestMapping("/checkAccount")
    @ResponseBody
    public Object checkAccount(String userAccount){

        AjaxMessage ajaxMessage = new AjaxMessage();
        Boolean flag=userService.toCheckAccount(userAccount);
        if(flag){
            ajaxMessage.setSuccess(true);
        }else {
            ajaxMessage.setSuccess(false);
        }
        return ajaxMessage;

    }

    //单个修改
    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(User user){
        AjaxMessage ajaxMessage = new AjaxMessage();
        Boolean flag=userService.editUser(user);
        if(flag){
            ajaxMessage.setSuccess(true);
        }else {
             ajaxMessage.setSuccess(false);
        }
        return ajaxMessage;

    }

    //单条删除
    @RequestMapping("/deleteByOne")
    public String deleteByOne(String id){
        try {
            userService.deleteByOne(Integer.valueOf(id));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "redirect:/user/index";
    }

}
