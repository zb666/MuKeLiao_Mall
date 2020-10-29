package com.imooc.mall.service.impl;

import com.imooc.mall.mapper.IUserMapper;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

}
