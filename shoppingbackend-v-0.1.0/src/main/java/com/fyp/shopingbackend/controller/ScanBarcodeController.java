package com.fyp.shopingbackend.controller;

import com.fyp.shopingbackend.controller.base.AbstractController;
import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.service.CommonService;
import com.fyp.shopingbackend.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.fyp.shopingbackend.controller.constant.RequestConstant.BAR_CODE;


/**
 * scan barcode, get product from database and return
 */
@RestController
public class ScanBarcodeController extends AbstractController {

    @Autowired
    private CommonService commonService;

    private final String[] REQUIRED = {BAR_CODE};

    /**
     * Handle.
     *
     * @param jsonRequest the json request
     * @param response    the response
     * @param request     the request
     * @throws Exception the exception
     */
    @PostMapping(value = "/1.0/scan", produces = "application/json")
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

        try {
            ProductDTO productDTO = commonService.scanBarCode(barCode);
            respMap.put("productCode", productDTO.getProductCode());
            respMap.put("productName", productDTO.getProductName());
            respMap.put("productImgPath", productDTO.getProductImgPath());
            respMap.put("productDesc", productDTO.getProductDescription());
            respMap.put("productPrice", MoneyUtil.getAmountStr(productDTO.getProductAmount(), productDTO.getProductCurrency()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return buildErrorResp(ex);
        }
        return respMap;
    }
}
