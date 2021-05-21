package com.fyp.shopingbackend.entity.repository.impl;

import com.fyp.shopingbackend.entity.OrderProductMapper;
import com.fyp.shopingbackend.entity.model.OrderProductDO;
import com.fyp.shopingbackend.entity.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The type Order product repository.
 */
@Service
public class OrderProductRepositoryImpl implements OrderProductRepository {

    /**
     * The Order product mapper.
     */
    @Autowired
    OrderProductMapper orderProductMapper;

    @Override
    public List<OrderProductDO> getOrderProductDoByOrderCode(String orderCode) {
        return orderProductMapper.getOrderProductDoByOrderCode(orderCode);
    }

    @Override
    public OrderProductDO getOrderProductDoByOrderCodeAndProductCode(String orderCode, String productCode) {
        return orderProductMapper.getOrderProductDoByOrderCodeAndProductCode(orderCode, productCode);
    }

    @Override
    public void updateOrderProductDoByOrderCodeAndProductCode(String orderCode, String productCode, int count) {
        orderProductMapper.updateOrderProductDoByOrderCodeAndProductCode(orderCode, productCode, count);
    }

    @Override
    public void insertOrderProductDo(String orderCode, String productCode, int quantity) {
        orderProductMapper.insertOrderProductDo(orderCode, productCode, quantity);
    }
}
