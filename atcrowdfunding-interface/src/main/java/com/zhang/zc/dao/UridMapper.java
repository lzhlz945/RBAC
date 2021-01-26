package com.zhang.zc.dao;

import com.zhang.zc.bean.Urid;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.dao
 * @date:2021/1/25
 */
public interface UridMapper {
    void deleteUserRoleById(Integer userId);

    void assignRole(List<Urid> list);
}
