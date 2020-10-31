package com.imooc.mall.controller;

import com.imooc.mall.MallConst;
import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.service.impl.UserServiceImpl;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/queryById")
    public ResponseVo<User> queryByUserId(@RequestParam Integer id){
        User userInfo = userMapper.selectByPrimaryKey(id);
        return new ResponseVo<User>(ResponseEnum.SUCCESS.getCode(),userInfo);
    }

    @PostMapping("/user/register")
    public ResponseVo<User> register(@RequestBody UserRegisterForm userForm){
        User user = new User();
        BeanUtils.copyProperties(userForm,user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(
           @Valid @RequestBody UserLoginForm userLoginForm,
           HttpSession httpSession){
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        httpSession.setAttribute(MallConst.CURRET_USER,userResponseVo.getData());
        log.info("/login sessionId={}",httpSession.getId());
        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userLogin(HttpSession session){
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRET_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}",session.getId());
        session.removeAttribute(MallConst.CURRET_USER);
        return ResponseVo.success();
    }


}
