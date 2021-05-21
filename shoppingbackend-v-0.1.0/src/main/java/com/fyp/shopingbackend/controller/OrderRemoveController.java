package com.fyp.shopingbackend.controller;

import com.fyp.shopingbackend.controller.base.AbstractController;
import com.fyp.shopingbackend.entity.model.OrderDTO;
import com.fyp.shopingbackend.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.fyp.shopingbackend.controller.constant.RequestConstant.BAR_CODE;
import static com.fyp.shopingbackend.controller.constant.RequestConstant.ORDER_CODE;
import static com.fyp.shopingbackend.controller.constant.RequestConstant.QUANTITY;


/**
 * add order controller
 */
@RestController
public class OrderRemoveController extends AbstractController {

    @Autowired
    private CommonService commonService;

    private final String[] REQUIRED = {BAR_CODE, QUANTITY};

    /**
     * Handle.
     *
     * @param jsonRequest the json request
     * @param response    the response
     * @param request     the request
     * @throws Exception the exception
     */
    @PostMapping(value = "/1.0/order/remove", produces = "application/json")
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

        String barCode = (String) getObject(o, BAR_CODE);
        String quantity = (String) getObject(o, QUANTITY);
        String orderCode = (String) getObject(o, ORDER_CODE);

        try {
            OrderDTO orderDTO = commonService.addOrder(orderCode, barCode, quantity);
            respMap.put("orderStatus", orderDTO.getOrderStatus());
            respMap.put("orderCode", orderDTO.getOrderCode());
        } catch (Exception ex) {
            ex.printStackTrace();
            return buildErrorResp(ex);
        }
        return respMap;
    }
}