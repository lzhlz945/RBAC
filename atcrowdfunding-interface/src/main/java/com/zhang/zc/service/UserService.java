package com.zhang.zc.service;

import com.zhang.zc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User query4login(User user);

    List<User> pageQuery(Map<String,String> map);

    int insert(User user);

    User selectOne(Integer userId);

    //检查账户是否重复
    Boolean toCheckAccount(String userAccount);

    //单条修改user
    Boolean editUser(User user);

    //单条删除
    void deleteByOne(Integer valueOf);

    //批量删除
    int deleteBach(String[] ids);

    User queryUserRole(Integer valueOf);
}
