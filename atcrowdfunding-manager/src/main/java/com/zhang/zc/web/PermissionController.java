package com.zhang.zc.web;

import com.zhang.zc.bean.AjaxMessage;
import com.zhang.zc.bean.Permission;
import com.zhang.zc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//        List<Permission> permission = new ArrayList<Permission>();
    /*    Permission root = new Permission();
        root.setName("顶级节点");
        Permission children = new Permission();
        children.setName("子节点");
        root.getChildren().add(children);
        permission.add(root);*/
//        List<Permission> menu=permissionService.queryPermissionMenu();
        List<Permission> menu2=permissionService.queryPermissionMenu1(0);

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
        return menu2;
    }


    @ResponseBody
    @RequestMapping("/loadRoleData")
    public Object loadRoleData(Integer rid){

        List<Permission> permissions=new ArrayList<Permission>();
//        List<Permission> menu=permissionService.queryPermissionMenu1(0);
        List<Permission> menu=permissionService.queryPermissionMenu2();
        List<Integer> ps=permissionService.queryPermissionByPid(rid);
//        Map<Integer,Permission> map=new HashMap<Integer, Permission>();
//        for (Permission menu1 : menu) {
//            map.put(menu1.getId(),menu1);
//        }
       /* for (Permission permission : menu) {
            if(ps.contains(permission.getId())){
                permission.setChecked(true);

            }else {
                permission.setChecked(false);
            }
        }*/
       Map<Integer,Permission> map=new HashMap<Integer, Permission>();
        for (Permission permission : menu) {
            map.put(permission.getId(),permission);
        }
        for (Permission permission : menu) {
            if(ps.contains(permission.getId())){
                permission.setChecked(true);
            }else {
                permission.setChecked(false);
            }
        }
        for (Permission permission : menu) {
            Permission children=permission;
            if(children.getPid()==0){
                permissions.add(permission);
            }else {
                Permission parent=map.get(permission.getPid());
                parent.getChildren().add(children);
            }
        }

        return permissions;
    }
    //跳转至菜单新增
    @RequestMapping("/toAdd")
    public String toAdd(){

        return "permission/add";
    }

    //验证菜单名称

    @RequestMapping("/checkPermissionName")
    @ResponseBody
    public Object checkPermissionName(String permissionname,Integer id){
        AjaxMessage ajaxMessage = new AjaxMessage();

        Permission permission=permissionService.selectPermissionById(id);
        Boolean flag=permissionService.checkPermissionName(permissionname);
        ajaxMessage.setData(permission);
        if(flag){
            ajaxMessage.setSuccess(true);
        }else {
            ajaxMessage.setSuccess(false);
        }
        return ajaxMessage;

    }

    //添加权限
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(Permission permission){

        AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            permissionService.insert(permission);

            ajaxMessage.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxMessage;

    }

    //跳转到修改菜单信息页面
    @RequestMapping("/toEdit")
    public String toEdit(Integer id,Model model){

        Permission permission=permissionService.selectPermissionById(id);
        model.addAttribute("permission",permission);
        return "permission/edit";
    }

    //修改permission信息
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Permission permission){

        AjaxMessage ajaxMessage = new AjaxMessage();

        try {
            permissionService.edit(permission);
            ajaxMessage.setSuccess(true);
        } catch (Exception e) {
            ajaxMessage.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxMessage;
    }

    //删除子节点
    @RequestMapping("/delete")
    public String deleteNode(Integer id){

        permissionService.deleteNode(id);
        return "redirect:/permission/index";
    }

}
