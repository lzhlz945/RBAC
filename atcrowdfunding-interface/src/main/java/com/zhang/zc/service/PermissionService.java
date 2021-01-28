package com.zhang.zc.service;

import com.zhang.zc.bean.Permission;
import com.zhang.zc.bean.User;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service
 * @date:2021/1/26
 */
public interface PermissionService {
    List<Permission> queryPermissionMenu();

    //使用xml
    List<Permission> queryPermissionMenu1(Integer id);

    //查询菜单名是否重复
    Boolean checkPermissionName(String permissionname);

    //添加菜单名称
    void  insert(Permission permission);

    Permission selectPermissionById(Integer id);

    //修改permission信息
    void edit(Permission permission);

    void deleteNode(Integer id);

    //查询已经分配的权限
    List<Integer> queryPermissionByPid(Integer rid);

    //查询全部
    List<Permission> queryPermissionMenu2();


    //查询用户权限
    List<Permission> queryUserPermission(User user1);
}
