package com.zhang.zc.dao;

import com.zhang.zc.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.dao
 * @date:2021/1/25
 */
public interface RoleMapper {
    List<Role> pageQuery(Map<String, String> map);

    List<Role> selectRoleList(Integer id);

    void deletePermissionByRid(Map<String, Object> map);

    void assignPermission(Map<String, Object> map);
}
