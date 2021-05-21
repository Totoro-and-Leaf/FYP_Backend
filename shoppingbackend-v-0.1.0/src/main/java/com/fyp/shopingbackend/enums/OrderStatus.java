package com.fyp.shopingbackend.enums;

/**
 * The enum Order status.
 */
public enum OrderStatus {

    /**
     * Init order status.
     */
    INIT("INIT"),
    /**
     * Paid order status.
     */
    PAID("PAID");

    private final String code;

    OrderStatus(String code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

}

