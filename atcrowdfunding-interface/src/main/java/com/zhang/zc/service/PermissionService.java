package com.zhang.zc.service;

import com.zhang.zc.bean.Permission;

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
}
