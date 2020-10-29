package com.imooc.mall.controller;

import com.imooc.mall.exception.UserLoginExceptionHandler;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
//
//    @RequestMapping("/findAll")
//    public ResponseVo<List<User>> findAll(){
//        List<User> users = userService.findAll();
//        return new ResponseVo<List<User>>(200,users);//userService.findAll();
//    }

//    @GetMapping("/findById/{id}")
//    public ResponseVo<User> findUserById(@PathVariable("id") Integer id){
//        if(id == 12)
//            throw new UserLoginExceptionHandler();
//        User user = userService.findUserById(id);
//        return new ResponseVo<User>(200,user);
//    }
//
//    @PostMapping("/updateUserInfo")
//    public ResponseVo<Integer> updateById(@Valid @RequestBody User user){
//        Integer integer = userService.updateById(user);
//        return new ResponseVo<Integer>(200,integer);
//    }
//
//    @DeleteMapping("/deleteUserById/{id}")
//    public ResponseVo<Void> deleteUserById(@PathVariable("id")Integer id){
//        userService.deleteById(id);
//        return new ResponseVo<Void>(200,"删除成功");
//    }
//

    @GetMapping("/queryById/{id}")
    public ResponseVo<User> queryById(@PathVariable("id") Integer id){
        User user = userService.selectByPrimaryKey(id);
        return new ResponseVo<User>(200,user);
    }


}
