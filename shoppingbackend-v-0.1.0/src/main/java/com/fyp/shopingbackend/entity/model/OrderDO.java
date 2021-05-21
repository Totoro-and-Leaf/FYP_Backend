package com.fyp.shopingbackend.entity.model;

import lombok.Data;

import java.util.Date;


/**
 * The type Order do.
 */
@Data
public class OrderDO {

    private String orderCode;

    private int amount;

    private String orderStatus;

    private Date createdTime;

    private Date paidTime;

    private Date modifiedTime;

    private String extendInfo;

}
