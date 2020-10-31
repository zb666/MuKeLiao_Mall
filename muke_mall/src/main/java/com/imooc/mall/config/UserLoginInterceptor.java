package com.imooc.mall.config;

import com.imooc.mall.MallConst;
import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    //先要调用登录接口才能获取到数据
    //或者直接调用HttpSession进行获取也是可以的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandler");
        User user = (User) request.getSession().getAttribute(MallConst.CURRET_USER);
        if(user == null) {
            log.info("user==null");
            throw new UserLoginException();
        }
        return true;
    }
}
