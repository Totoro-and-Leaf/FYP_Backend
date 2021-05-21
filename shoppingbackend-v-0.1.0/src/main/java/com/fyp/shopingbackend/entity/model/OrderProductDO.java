package com.fyp.shopingbackend.entity.model;

import lombok.Data;

import java.util.Date;


/**
 * The type Order product do.
 */
@Data
public class OrderProductDO {

    private String orderProductCode;

    private String orderCode;

    private String productCode;

    private int quantity;

    private String memo;

    private Date createdTime;

    private Date modifiedTime;

    private String extendInfo;

}
