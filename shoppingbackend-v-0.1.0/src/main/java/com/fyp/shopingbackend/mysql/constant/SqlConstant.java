
package com.fyp.shopingbackend.mysql.constant;

/**
 * SQL query
 */
@Deprecated
public interface SqlConstant {

    String GET_PRODUCT_BY_PRODUCT_CODE = "SELECT * FROM PRODUCT WHERE product_code = ?";

    String INSERT_ORDER = "INSERT INTO order_product (`order_code`, `product_code`, `quantity`, `memo`) VALUES ( ?, ?, ?, ' ')";

    String UPDATE_CART_AMOUNT = "UPDATE `order` SET amount = ? WHERE order_code = ?";


}
