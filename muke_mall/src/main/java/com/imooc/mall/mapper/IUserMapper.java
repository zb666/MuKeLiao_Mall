package com.imooc.mall.mapper;

import com.imooc.mall.pojo.User;

import java.util.List;

public interface IUserMapper {

    List<User> findAll();

}