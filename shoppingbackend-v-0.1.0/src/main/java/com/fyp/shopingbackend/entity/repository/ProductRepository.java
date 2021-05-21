package com.fyp.shopingbackend.entity.repository;

import com.fyp.shopingbackend.entity.model.ProductDO;


/**
 * The interface Product repository.
 */
public interface ProductRepository {

    /**
     * Gets product do by product code.
     *
     * @param productCode the product code
     * @return product do by product code
     */
    ProductDO getProductDoByProductCode(String productCode);


}