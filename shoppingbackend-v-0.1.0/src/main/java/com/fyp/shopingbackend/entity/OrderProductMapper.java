package com.fyp.shopingbackend.entity;

import com.fyp.shopingbackend.entity.model.OrderProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * The interface Order product mapper.
 */
@Mapper
public interface OrderProductMapper {

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

    /**
     * Remove(-1) order product do.
     *
     * @param orderCode   the order code
     * @param productCode the product code
     * @param quantity    the quantity
     */
    
    
    void removeOrderProductDo(String orderCode, String productCode, int quantity)
}