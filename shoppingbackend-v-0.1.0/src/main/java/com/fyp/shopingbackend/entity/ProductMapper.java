package com.fyp.shopingbackend.entity;

import com.fyp.shopingbackend.entity.model.ProductDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * The interface Product mapper.
 */
@Mapper
public interface ProductMapper {

    /**
     * Gets product do by product code.
     *
     * @param productCode the product code
     * @return product do by product code
     */
    ProductDO getProductDoByProductCode(String productCode);

}