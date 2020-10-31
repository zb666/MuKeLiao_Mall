package com.imooc.mall.interceptor;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TotalExceptionHandler {

    @ExceptionHandler(UserLoginExceptionHandler.class)
    @ResponseBody
    public ResponseVo userLoginHandler(){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

}
