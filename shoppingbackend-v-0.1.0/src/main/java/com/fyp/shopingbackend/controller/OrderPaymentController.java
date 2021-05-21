package com.fyp.shopingbackend.controller;

import com.fyp.shopingbackend.controller.base.AbstractController;
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
 * Payment controller
 * This controller will integrate with 3rd party in future
 * Currently mock the response time to 2 sec
 */
@RestController
public class OrderPaymentController extends AbstractController {

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
    @PostMapping(value = "/1.0/order/pay", produces = "application/json")
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
            Thread.sleep(2000);
            commonService.payment(orderCode);
            respMap.put("OK", "OK");
        } catch (Exception ex) {
            return buildErrorResp(ex);
        }

        return respMap;
    }
}
