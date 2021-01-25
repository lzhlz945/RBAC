package com.zhang.zc.service.impl;

import com.zhang.zc.bean.Role;
import com.zhang.zc.bean.User;
import com.zhang.zc.dao.RoleMapper;
import com.zhang.zc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service.impl
 * @date:2021/1/25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> pageQuery(Map<String, String> map) {

        return  roleMapper.pageQuery(map);
    }
}
