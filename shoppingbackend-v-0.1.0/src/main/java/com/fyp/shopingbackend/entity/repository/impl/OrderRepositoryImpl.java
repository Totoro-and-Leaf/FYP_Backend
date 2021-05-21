package com.fyp.shopingbackend.entity.repository.impl;

import com.fyp.shopingbackend.entity.OrderMapper;
import com.fyp.shopingbackend.entity.model.OrderDO;
import com.fyp.shopingbackend.entity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Order repository.
 */
@Service
public class OrderRepositoryImpl implements OrderRepository {

    /**
     * The Order mapper.
     */
    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDO getOrderDoByOrderCode(String orderCode) {
        return orderMapper.getOrderDoByOrderCode(orderCode);
    }

    @Override
    public void createOrderDo(String orderCode) {
        orderMapper.createOrder(orderCode);
    }

    @Override
    public void updateOrder(String orderCode, int amount) {
        orderMapper.updateOrder(orderCode, amount);
    }

    @Override
    public void payment(String orderCode) {
        orderMapper.payment(orderCode);
    }


}
