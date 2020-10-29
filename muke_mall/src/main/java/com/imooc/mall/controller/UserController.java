package com.imooc.mall.controller;

import com.imooc.mall.dao.ICategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userQuery")
    public ResponseVo<User> getUserName(){
        User user = new User();
        user.setUsername("张三");
        user.setAnswer("答案");
        user.setEmail("1360799362@qq.com");
        user.setId(1);
        user.setPhone("15757821905");
        return new ResponseVo<User>(200,user);
    }

    @RequestMapping("/findAll")
    public ResponseVo<List<User>> findAll(){
        List<User> users = userService.findAll();
        return new ResponseVo<List<User>>(200,users);//userService.findAll();
    }





}
