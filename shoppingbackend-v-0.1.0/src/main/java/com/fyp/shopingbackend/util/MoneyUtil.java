
package com.fyp.shopingbackend.util;

import java.math.BigDecimal;


/**
 * Money utils
 */
public class MoneyUtil {

    private final static String MYR = "MYR";

    /**
     * Gets amount.
     *
     * @param val      the val
     * @param currency the currency
     * @return the amount
     */
    public static BigDecimal getAmount(int val, String currency) {
        return BigDecimal.valueOf(val, getRounding(currency));
    }

    /**
     * Gets amount str.
     *
     * @param val the val
     * @return the amount str
     */
    public static String getAmountStr(int val) {
        return getAmountStr(val, MYR);
    }

    /**
     * Gets amount str.
     *
     * @param val      the val
     * @param currency the currency
     * @return the amount str
     */
    public static String getAmountStr(int val, String currency) {
        return getCurrencyTitle(currency) + BigDecimal.valueOf(val, getRounding(currency));
    }

    private static int getRounding(String currency) {
        if (MYR.equals(currency)) {
            return 2;
        }
        return 2;
    }

    private static String getCurrencyTitle(String cur){
        switch (cur) {
            case "MYR":
                return "RM ";
            default:
                return cur;
        }
    }

}
