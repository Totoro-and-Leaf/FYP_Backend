package com.fyp.shopingbackend.entity.repository;

import com.fyp.shopingbackend.entity.model.OrderDO;


/**
 * The interface Order repository.
 */
public interface OrderRepository {

    /**
     * Gets order do by order code.
     *
     * @param orderCode the order code
     * @return order do by order code
     */
    OrderDO getOrderDoByOrderCode(String orderCode);

    /**
     * Create order do.
     *
     * @param orderCode the order code
     */
    void createOrderDo(String orderCode);

    /**
     * Update order.
     *
     * @param orderCode the order code
     * @param amount    the amount
     */
    void updateOrder(String orderCode, int amount);

    /**
     * Payment.
     *
     * @param orderCode the order code
     */
    void payment(String orderCode);

}