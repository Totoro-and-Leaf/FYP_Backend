package com.fyp.shopingbackend.entity.model;

import lombok.Data;

import java.util.Date;


/**
 * The type Product do.
 */
@Data
public class ProductDO {

    private String productCode;

    private String merchantCode;

    private String productName;

    private String productImgPath;

    private String productDescription;

    private String productCurrency;

    private int productAmount;

    private String productStatus;

    private String categoryCode;

    private Date createdTime;

    private Date modifiedTime;

    private String extendInfo;
}
