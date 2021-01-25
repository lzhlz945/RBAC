package com.zhang.zc.service;

import com.zhang.zc.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service
 * @date:2021/1/25
 */
public interface RoleService {
    //role异步分页
    List<Role> pageQuery(Map<String, String> map);

    //查询role的所有记录
    List<Role> selectRoleList();
}
