package com.zhang.zc.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.Role;
import com.zhang.zc.bean.User;
import com.zhang.zc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
