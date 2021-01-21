package com.zhang.zc.service.impl;

import com.zhang.zc.bean.User;
import com.zhang.zc.dao.UserMapper;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User query4login(User user) {
        User user1=userMapper.query4login(user);
        return user1;
    }
}
