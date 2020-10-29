package com.imooc.mall.service;

import com.imooc.mall.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Integer id);
    Integer updateById(User user);
    void deleteById(Integer id);
}
