package com.fyp.shopingbackend.controller;

import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.entity.repository.CommonRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Testing controller
 */
@RestController
public class EnchoController {

    @Autowired
    private CommonRepositoryService commonRepositoryService;

    /**
     * Encho 1 string.
     *
     * @return the string
     */
    @RequestMapping(value = "/1.0/test1")
    public String encho1() {
        ProductDTO dto = commonRepositoryService.getProductDTO("PRD000001");
        return dto.toString();
    }

    /**
     * Encho 2 string.
     *
     * @return the string
     */
    @RequestMapping(value = "/1.0/test2")
    public String encho2() {
        return "encho success";
    }


}
