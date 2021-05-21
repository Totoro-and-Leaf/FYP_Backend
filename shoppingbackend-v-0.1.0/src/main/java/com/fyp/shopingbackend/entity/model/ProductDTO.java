package com.fyp.shopingbackend.entity.model;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The type Product dto.
 */
@Data
public class ProductDTO {

    private String productCode;

    private String productName;

    private String productImgPath;

    private String productDescription;

    private String productCurrency;

    private int productAmount;

    private BigDecimal amount;

}
