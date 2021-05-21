package com.fyp.shopingbackend.entity.model;

import lombok.Data;

import java.util.List;


/**
 * The type Shoping dto.
 */
@Data
public class ShopingDTO {

    private String orderCode;

    private String amount;

    /**
     * The Product dto list.
     */
    List<OrderProductDTO> productDTOList;

    private String orderStatus;

    private String extendInfo;

}
