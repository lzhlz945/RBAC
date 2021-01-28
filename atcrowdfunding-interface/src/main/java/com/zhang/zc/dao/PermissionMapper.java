package com.zhang.zc.dao;

import com.zhang.zc.bean.Permission;
import com.zhang.zc.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.dao
 * @date:2021/1/26
 */
public interface PermissionMapper {
    @Select("select * from permission")
    List<Permission> queryPermissionMenu();

    List<Permission> queryPermissionMenu1(Integer id);

    int checkPermissionName(String permissionname);

    void insert(Permission permission);

    Permission selectPermissionById(Integer id);

    void edit(Permission permission);

    void deleteNode(Integer id);

    void deleteChildrenNode(Integer id);


    List<Integer> queryPermissionByPid(Integer rid);

    List<Permission> queryPermissionMenu2();

    List<Permission> queryUserPermission(User user1);
}
