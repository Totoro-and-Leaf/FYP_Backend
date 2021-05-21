package com.fyp.shopingbackend.entity;

import com.fyp.shopingbackend.entity.model.OrderDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * The interface Order mapper.
 */
@Mapper
public interface OrderMapper {

    /**
     * Gets order do by order code.
     *
     * @param orderCode the order code
     * @return order do by order code
     */
    OrderDO getOrderDoByOrderCode(String orderCode);

    /**
     * Update order.
     *
     * @param orderCode the order code
     * @param amount    the amount
     */
    void updateOrder(String orderCode, int amount);

    /**
     * Create order.
     *
     * @param orderCode the order code
     */
    void createOrder(String orderCode);

    /**
     * Payment.
     *
     * @param orderCode the order code
     */
    void payment(String orderCode);

}