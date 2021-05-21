package com.fyp.shopingbackend.service.impl;

import com.fyp.shopingbackend.entity.model.OrderDTO;
import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.entity.model.ShopingDTO;
import com.fyp.shopingbackend.entity.repository.CommonRepositoryService;
import com.fyp.shopingbackend.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * common service implementation class
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonRepositoryService commonRepositoryService;

    @Override
    public ProductDTO scanBarCode(String barcode) {
        return commonRepositoryService.getProductDTO(barcode);
    }

    @Override
    public OrderDTO addOrder(String orderCode, String barcode, String quantity) {
        int quantityVal ;
        try {
         quantityVal = Integer.parseInt(quantity);
        } catch (Exception ignored){
            quantityVal = 0;
        }
        return commonRepositoryService.addOrder(orderCode, barcode, quantityVal);
    }

    @Override
    public ShopingDTO orderCheckout(String orderCode) {
        return commonRepositoryService.orderCheckout(orderCode);
    }

    @Override
    public boolean payment(String orderCode) {
        return commonRepositoryService.payment(orderCode);
    }

}
