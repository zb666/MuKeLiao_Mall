package com.imooc.dao;

import com.imooc.mall.MallApplication;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallApplication.class)
@Transactional
@Slf4j
public class MallApplicationTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;


    public static void main(String[] args) {
        System.out.println("11111");
    }

    @Test
    public void testUser(){
        User user = new User("jack","123456","1360799362@qq.com",1);
        userService.register(user);
    }

    @Test
    public void queryUser(){
        int jack = userMapper.countByUsername("jack");
        System.out.println("UserCount: "+jack);
    }

    @Test
    public void testCategory(){
        Product product = productMapper.selectByPrimaryKey(26);
        log.info("Product: "+product.toString());
    }

}
