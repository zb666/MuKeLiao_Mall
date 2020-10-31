package com.imooc.dao.service;

import com.google.gson.Gson;
import com.imooc.dao.MallApplicationTest;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CartServiceTest extends MallApplicationTest {

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer productId = 26;

    private Gson mGson = new Gson();

    @Before
    public void add(){
        log.info("新增购物车");
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(productId);
        cartAddForm.setSelected(true);
        ResponseVo<CartVo> cartVoResponseVo = cartService.add(uid, cartAddForm);
        log.info("AAA: "+cartVoResponseVo.getStatus() + cartVoResponseVo.getData());
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),cartVoResponseVo.getStatus());
    }

    @Test
    public void list(){
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("list={}",mGson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    public void delete(){
        log.info("删除购物车");
        ResponseVo<CartVo> cartVoResponseVo = cartService.delete(uid, productId);
        log.info("result={}",mGson.toJson(cartVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),cartVoResponseVo.getStatus());
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("result={}", mGson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("result={}", mGson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("result={}", mGson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }




}
