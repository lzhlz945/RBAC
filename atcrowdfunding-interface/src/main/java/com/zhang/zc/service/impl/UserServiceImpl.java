package com.zhang.zc.service.impl;

import com.zhang.zc.bean.User;
import com.zhang.zc.dao.UserMapper;
import com.zhang.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


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
    public List<User> pageQuery(Map<String,String> map) {
        return userMapper.pageQuery(map);
    }

    @Override
    public int insert(User user) {
        user.setPassword(user.getUserAccount());
        int account=userMapper.insert(user);
        return account;
    }

    //单个修改查询记录
    @Override
    public User selectOne(Integer userId) {
        return userMapper.selectOne(userId);
    }

    @Override
    public Boolean toCheckAccount(String userAccount) {
       int count= userMapper.toCheckAccount(userAccount);
       if(count<=0){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public Boolean editUser(User user) {
        user.setPassword(user.getUserAccount());
        int count=userMapper.editUser(user);
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deleteByOne(Integer id) {
        userMapper.deleteByOne(id);
    }

    @Override
    public int deleteBach(String[] ids) {
        return userMapper.deleteBach(ids);
    }

    @Override
    public User queryUserRole(Integer id) {


        return userMapper.queryUserRole(id);
    }
}
