package com.imooc.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.OrderItemMapper;
import com.imooc.mall.dao.OrderMapper;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Transactional
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验

        //获取购物车，校验

        //获取CartLists里的ProductsIds

        //根据ProductId查询数据库

        //	Long orderNo = generateOrderNo(); 获取分布式的事务ID

        //是否满足有商品 上架，库存充足这三者的情况

        //如果满足则商城购物车，同时将库存减一

        //计算总价

        //生成订单，入库

        //更新购物车 Redis操作

        //返回创建的商品信息
        return null;
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseVo<OrderVo> detail(Integer uid, Long orderNo) {
        return null;
    }

    @Override
    public ResponseVo cancel(Integer uid, Long orderNo) {
        return null;
    }

    @Override
    public void paid(Long orderNo) {

    }

    /**
     * 企业级：分布式唯一id/主键
     * @return
     */
    private Long generateOrderNo() {
        return System.currentTimeMillis() + new Random().nextInt(999);
    }

}
