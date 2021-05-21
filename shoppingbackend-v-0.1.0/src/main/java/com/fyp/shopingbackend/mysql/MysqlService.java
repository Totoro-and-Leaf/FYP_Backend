
package com.fyp.shopingbackend.mysql;

import com.fyp.shopingbackend.mysql.constant.SqlConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Direct connect to mySQL using mySQL connector
 */
@Deprecated
@Service
public class MysqlService {

    @Value("${datasourceUrl}")
    private String datasourceUrl;

    @Value("${credentials.user}")
    private String user;

    @Value("${credentials.pass}")
    private String password;

    /**
     * get product
     * @param productCode
     */
    public void getProductByProductCode(String productCode) {

        Connection databaseConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(datasourceUrl, user, password);

            String sql = SqlConstant.GET_PRODUCT_BY_PRODUCT_CODE;
            PreparedStatement stmt = databaseConnection.prepareStatement(sql);
            stmt.setString(1, productCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (databaseConnection != null) {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * update shoping cart
     * @param productCode
     * @param quantity
     * @param cartId
     * @param amount
     */
    public void updateShopingCart(String productCode, String quantity, String cartId, String amount){
        Connection databaseConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(datasourceUrl, user, password);

            String sql = SqlConstant.INSERT_ORDER;
            PreparedStatement stmt = databaseConnection.prepareStatement(sql);
            stmt.setString(1, cartId);
            stmt.setString(2, productCode);
            stmt.setString(3, quantity);
            int rs = stmt.executeUpdate();


            String updateCartAmount = SqlConstant.UPDATE_CART_AMOUNT;
            PreparedStatement smt2 = databaseConnection.prepareStatement(updateCartAmount);
            smt2.setString(1, amount);
            smt2.setString(2, cartId);
            smt2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (databaseConnection != null) {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
