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

}
