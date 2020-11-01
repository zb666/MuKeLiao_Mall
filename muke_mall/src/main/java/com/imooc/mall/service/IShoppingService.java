package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;

import java.util.Map;

/**
 * 购物车地址
 */
public interface IShoppingService {

    ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm shippingForm);

    ResponseVo delete(Integer uid,Integer shippingId);

    ResponseVo update(Integer uid,Integer shippingId,ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid,Integer pageNum,Integer pageSize);

}
