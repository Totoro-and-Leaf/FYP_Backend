package com.fyp.shopingbackend.service;

import com.fyp.shopingbackend.entity.model.OrderDTO;
import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.entity.model.ShopingDTO;


/**
 * services
 */
public interface CommonService {

    /**
     * Scan bar code
     *
     * @param barcode the barcode
     * @return product dto
     */
    ProductDTO scanBarCode(String barcode);

    /**
     * Add product to shoping cart
     *
     * @param orderCode the order code
     * @param barcode   the barcode
     * @param quantity  the quantity
     * @return order dto
     */
    OrderDTO addOrder(String orderCode, String barcode, String quantity);

    /**
     * view all order product
     *
     * @param orderCode the order code
     * @return shoping dto
     */
    ShopingDTO orderCheckout(String orderCode);

    /**
     * make payment
     *
     * @param orderCode the order code
     * @return boolean
     */
    boolean payment(String orderCode);

}
