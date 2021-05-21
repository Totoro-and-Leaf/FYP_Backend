package com.fyp.shopingbackend.controller;

import com.fyp.shopingbackend.controller.base.AbstractController;
import com.fyp.shopingbackend.entity.model.ShopingDTO;
import com.fyp.shopingbackend.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.fyp.shopingbackend.controller.constant.RequestConstant.ORDER_CODE;

/**
 * checkout order
 */
@RestController
public class OrderCheckoutController extends AbstractController {

    @Autowired
    private CommonService commonService;

    private final String[] REQUIRED = {ORDER_CODE};

    /**
     * Handle.
     *
     * @param jsonRequest the json request
     * @param response    the response
     * @param request     the request
     * @throws Exception the exception
     */
    @PostMapping(value = "/1.0/order/checkout", produces = "application/json")
    public void handle(@RequestBody String jsonRequest, HttpServletResponse response, HttpServletRequest request) throws Exception {
        sendResponse(parseResponse(jsonRequest, request), response);
    }

    @Override
    protected String[] requiredField() {
        return REQUIRED;
    }

    @Override
    protected Map<String, Object> doService(Object o) {

        Map<String, Object> respMap = new HashMap<>();

        String orderCode = (String) getObject(o, ORDER_CODE);
        try {
            ShopingDTO dto = commonService.orderCheckout(orderCode);
            respMap.put("orderCode", dto.getOrderCode());
            respMap.put("orderProductList", dto.getProductDTOList());
            respMap.put("orderAmount", dto.getAmount());

        } catch (Exception ex) {
            ex.printStackTrace();
            return buildErrorResp(ex);
        }
        return respMap;
    }
}
