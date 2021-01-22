package com.zhang.zc.service.impl;

import com.zhang.zc.bean.User;
import com.zhang.zc.dao.UserMapper;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User query4login(User user) {
        User user1=userMapper.query4login(user);
        return user1;
    }

    //分页查询
    @Override
    public List<User> pageQuery(Map<String, Object> map) {
        return userMapper.pageQuery(map);
    }
}
