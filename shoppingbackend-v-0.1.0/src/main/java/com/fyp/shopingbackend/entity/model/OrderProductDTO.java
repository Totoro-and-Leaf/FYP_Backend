package com.fyp.shopingbackend.entity.model;

import com.fyp.shopingbackend.util.MoneyUtil;
import lombok.Data;


/**
 * The type Order product dto.
 */
@Data
public class OrderProductDTO {

    private String productName;

    private int quantity;

    private int unitPrice;

    private String totalPrice;

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public String getTotalPrice() {
        return MoneyUtil.getAmountStr(this.unitPrice * this.quantity, "MYR");
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public String getUnitPrice() {
        return MoneyUtil.getAmountStr(this.unitPrice,"MYR");
    }
}
