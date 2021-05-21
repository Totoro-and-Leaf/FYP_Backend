
package com.fyp.shopingbackend.enums;


/**
 * The enum Currency.
 */
public enum Currency {

    /**
     * Myr currency.
     */
    MYR("MYR");
    private final String name;

    Currency(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
