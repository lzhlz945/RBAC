package com.zhang.zc.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.Role;
import com.zhang.zc.bean.Urid;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.RoleService;
import com.zhang.zc.service.UridService;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.web
 * @date:2021/1/25
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UridService uridService;
    @Autowired
    private UserService userService;


    //跳转到role分页页面
    @RequestMapping("/index")
    public String toRole(){
        return "/role/index";
    }


    //异步分页信息
    @RequestMapping("/pages")
    @ResponseBody
    public Object showPages(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize,
                            @RequestParam(value = "name")String name){
        AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            Map<String,String> map=new HashMap<String, String>();
            map.put("name",name);
            PageHelper.startPage(pageNum,pageSize);
            List<Role> userList=roleService.pageQuery(map);
            PageInfo<Role> pageInfo1=new PageInfo<Role>(userList,3);
            pageInfo1.setNavigatePages(3);
            ajaxMessage.setSuccess(true);
            ajaxMessage.setData(pageInfo1);

        } catch (Exception e) {
            ajaxMessage.setSuccess(false);
            e.printStackTrace();
        }

        return ajaxMessage;
    }

    //跳转分配权限
    @RequestMapping("/toAssign")
    public String toAssign(String userId, Model model){

        //查询用户角色没有被分配的
        List<Role> roleList=roleService.selectRoleList(Integer.valueOf(userId));
        //查询出当前user的角色的职位信息

        User user1=userService.queryUserRole(Integer.valueOf(userId));

        if(user1!=null){

        List<Role> userRole = user1.getRole();
        model.addAttribute("userRole",userRole);
        }
        model.addAttribute("userId",userId);
        model.addAttribute("rList",roleList);
        return "role/assignRole";


    }

    //授权：先删除以前的权限在来授权
    @RequestMapping("/assignRole")
    @ResponseBody
    public Object assignRole(Integer[] ids,Integer userId){
        System.out.println(ids);
        System.out.println(userId);
            AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            //角色控制
            uridService.assignRole(ids,userId);
            ajaxMessage.setSuccess(true);

        } catch (Exception e) {
            ajaxMessage.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxMessage;
    }



}
