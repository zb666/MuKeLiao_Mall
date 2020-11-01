package com.imooc.mall.controller;

import com.imooc.mall.MallConst;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IShoppingService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ShippingController {

    @Autowired
    private IShoppingService shoppingService;

    @GetMapping("/shippings")
    public ResponseVo add(@RequestBody ShippingForm shippingForm, HttpSession httpSession){
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        return shoppingService.add(user.getId(),shippingForm);
    }

}
