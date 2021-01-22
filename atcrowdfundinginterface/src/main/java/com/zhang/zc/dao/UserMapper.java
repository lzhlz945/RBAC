package com.zhang.zc.dao;

import com.zhang.zc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User query4login(User user);

    List<User> pageQuery(Map<String, Object> map);
}
