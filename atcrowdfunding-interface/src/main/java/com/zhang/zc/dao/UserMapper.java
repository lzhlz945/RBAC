package com.zhang.zc.dao;

import com.zhang.zc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User query4login(User user);

    List<User> pageQuery(Map<String,String> map);

    int insert(User user);

    User selectOne(Integer userId);

    int toCheckAccount(String userAccount);

    int editUser(User user);

    void deleteByOne(Integer id);

    int deleteBach(String[] ids);
}
