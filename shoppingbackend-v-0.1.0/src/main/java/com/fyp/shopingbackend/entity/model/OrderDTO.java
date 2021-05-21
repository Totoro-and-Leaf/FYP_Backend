package com.fyp.shopingbackend.entity.model;

import lombok.Data;


/**
 * The type Order dto.
 */
@Data
public class OrderDTO {

    private String orderCode;

    private String orderProductCode;

    private ProductDO productDO;

    private String orderStatus;

    private String quantity;

    private String extendInfo;

}
