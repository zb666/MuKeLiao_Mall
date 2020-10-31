package com.imooc.service;

import com.imooc.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//跳过单测的指令DMaven
@Transactional
@Slf4j
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "张三";

    public static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @Before
    public void register(){
        User user = new User(USERNAME,PASSWORD,"1360799362@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login(){
        ResponseVo<User> userResponseVo = userService.login(USERNAME, PASSWORD);
        log.info("UserInfo: "+userResponseVo.toString());
        Assert.assertEquals(userResponseVo.getStatus(), ResponseEnum.SUCCESS.getCode());
    }

}
