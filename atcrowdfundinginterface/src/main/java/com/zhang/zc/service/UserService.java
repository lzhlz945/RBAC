package com.zhang.zc.service;

import com.zhang.zc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User query4login(User user);

    List<User> pageQuery(Map<String,String> map);
}
