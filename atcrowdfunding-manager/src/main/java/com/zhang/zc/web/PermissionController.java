package com.zhang.zc.web;

import com.zhang.zc.bean.Permission;
import com.zhang.zc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.web
 * @date:2021/1/26
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/index")
    public String toIndex(){


        return "permission/index";
    }

    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData(){

        List<Permission> permission = new ArrayList<Permission>();
    /*    Permission root = new Permission();
        root.setName("顶级节点");
        Permission children = new Permission();
        children.setName("子节点");
        root.getChildren().add(children);
        permission.add(root);*/
        Permission menu2=permissionService.queryPermissionMenu1(0);
        List<Permission> menu=permissionService.queryPermissionMenu();
        permission.add(menu2);
        //ArrayList比LinkedList 查询快，有索引  map必用到索引
        /*Map<Integer,Permission> map=new HashMap<Integer, Permission>();
        for (Permission menu1 : menu) {
            map.put(menu1.getId(),menu1);
        }
        for (Permission menu1 : menu) {
            Permission children=menu1;
            if(children.getPid() == 0){
                permission.add(menu1);
            }else {
                Permission parent = map.get(children.getPid());
                parent.getChildren().add(children);
            }
        }*/
        return permission;
    }
}
