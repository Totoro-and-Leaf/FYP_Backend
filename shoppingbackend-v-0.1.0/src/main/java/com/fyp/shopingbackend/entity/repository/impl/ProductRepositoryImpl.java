package com.fyp.shopingbackend.entity.repository.impl;

import com.fyp.shopingbackend.entity.ProductMapper;
import com.fyp.shopingbackend.entity.model.ProductDO;
import com.fyp.shopingbackend.entity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Product repository.
 */
@Service
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDO getProductDoByProductCode(String productCode) {
        return productMapper.getProductDoByProductCode(productCode);
    }
}
