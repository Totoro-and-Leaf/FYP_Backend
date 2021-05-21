package com.fyp.shopingbackend.entity.repository;

import com.fyp.shopingbackend.entity.model.OrderProductDO;

import java.util.List;


/**
 * The interface Order product repository.
 */
public interface OrderProductRepository {

    /**
     * Gets order product do by order code.
     *
     * @param orderCode the order code
     * @return order product do by order code
     */
    List<OrderProductDO> getOrderProductDoByOrderCode(String orderCode);

    /**
     * Gets order product do by order code and product code.
     *
     * @param orderCode   the order code
     * @param productCode the product code
     * @return order product do by order code and product code
     */
    OrderProductDO getOrderProductDoByOrderCodeAndProductCode(String orderCode, String productCode);

    /**
     * Update order product do by order code and product code.
     *
     * @param orderCode   the order code
     * @param productCode the product code
     * @param count       the count
     */
    void updateOrderProductDoByOrderCodeAndProductCode(String orderCode, String productCode, int count);

    /**
     * Insert order product do.
     *
     * @param orderCode   the order code
     * @param productCode the product code
     * @param quantity    the quantity
     */
    void insertOrderProductDo(String orderCode, String productCode, int quantity);

}