package com.fyp.shopingbackend.controller.base;

import com.alibaba.fastjson.JSON;
import com.fyp.shopingbackend.logging.Loggers;
import com.fyp.shopingbackend.logging.LoggingUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


/**
 * Abstract base class for API
 */
public abstract class AbstractController {

    /**
     * process controller logic
     *
     * @param o       the o
     * @param request the request
     * @return string
     */
    protected String parseResponse(Object o, HttpServletRequest request) {

        LoggingUtil.info(Loggers.SHOP_HTTP, this.getClass().getSimpleName() + "Request - " + o);

        if (!StringUtils.isEmpty(requiredField())) {
            try {
                checkMandatoryField(o.toString());
            } catch (JSONException e) {
                return e.getMessage();
            }
        }

        String response = JSON.toJSONString(doService(o));
        LoggingUtil.info(Loggers.SHOP_HTTP, this.getClass().getSimpleName() + "Response - " + response);
        return response;
    }

    /**
     * Check all required parameters
     *
     * @param jsonString
     * @throws JSONException
     */
    private void checkMandatoryField(String jsonString) throws JSONException {
        JSONObject json = new JSONObject(jsonString);
        for (String requiredField : requiredField()) {
            if (!json.has(requiredField)) {
                throw new JSONException("Missing Required Value : " + requiredField);
            }
        }
    }

    /**
     * build error response msg
     *
     * @param exception the exception
     * @return the map
     */
    protected Map<String, Object> buildErrorResp(Exception exception){
        Map<String, Object> respMap = new HashMap<>();
        respMap.put("ERROR", exception.toString());
        return respMap;
    }

    /**
     * Get object from request
     *
     * @param o     the o
     * @param field the field
     * @return object
     */
    protected Object getObject(Object o, String field) {

        Object val = null;

        try {
            JSONObject json = new JSONObject(o.toString());
            val = json.has(field) ? json.get(field) : null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * Send the response
     *
     * @param respData the resp data
     * @param response the response
     * @throws Exception the exception
     */
    protected void sendResponse(String respData, HttpServletResponse response) throws Exception {
        Writer writer = response.getWriter();
        writer.write(respData);
        writer.flush();
        writer.close();
    }

    /**
     * get the list of required field
     *
     * @return string [ ]
     */
    protected abstract String[] requiredField();

    /**
     * Apply all business logic over here
     *
     * @param o the o
     * @return map
     */
    protected abstract Map<String, Object> doService(Object o);

}
