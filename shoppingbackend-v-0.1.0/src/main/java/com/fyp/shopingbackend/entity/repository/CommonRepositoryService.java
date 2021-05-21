package com.fyp.shopingbackend.entity.repository;

import com.fyp.shopingbackend.entity.model.OrderDTO;
import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.entity.model.ShopingDTO;

/**
 * central repository service
 */
public interface CommonRepositoryService {

    /**
     * Gets product dto.
     *
     * @param productCode the product code
     * @return product dto
     */
    ProductDTO getProductDTO(String productCode);

    /**
     * Add order order dto.
     *
     * @param orderCode the order code
     * @param barcode   the barcode
     * @param quantity  the quantity
     * @return order dto
     */
    OrderDTO addOrder(String orderCode, String barcode, int quantity);

    /**
     * Order checkout shoping dto.
     *
     * @param orderCode the order code
     * @return shoping dto
     */
    ShopingDTO orderCheckout(String orderCode);

    /**
     * Payment boolean.
     *
     * @param orderCode the order code
     * @return boolean
     */
    boolean payment(String orderCode);


}
