package com.zhang.zc.service;

import com.zhang.zc.bean.Urid;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service
 * @date:2021/1/25
 */
public interface UridService {

    //角色控制
    void assignRole(Integer[] ids, Integer userId);
}
