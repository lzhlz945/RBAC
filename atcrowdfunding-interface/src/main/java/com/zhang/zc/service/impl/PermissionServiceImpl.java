package com.zhang.zc.service.impl;

import com.zhang.zc.bean.Permission;
import com.zhang.zc.dao.PermissionMapper;
import com.zhang.zc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service.impl
 * @date:2021/1/26
 */

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> queryPermissionMenu() {
        return permissionMapper. queryPermissionMenu();
    }

    @Override
    public List<Permission> queryPermissionMenu1(Integer id) {
        return  permissionMapper. queryPermissionMenu1(id);
    }

    @Override
    public Boolean checkPermissionName(String permissionname) {
       int count= permissionMapper.checkPermissionName(permissionname);
       if(count <= 0){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public void insert(Permission permission) {
       permissionMapper.insert(permission);


    }

    @Override
    public Permission selectPermissionById(Integer id) {
        return permissionMapper.selectPermissionById(id);
    }

    @Override
    public void edit(Permission permission) {
        permissionMapper.edit(permission);
    }

    @Override
    public void deleteNode(Integer id) {
        permissionMapper.deleteNode(id);
        permissionMapper.deleteChildrenNode(id);
//        System.out.println(10/0);
    }
}
