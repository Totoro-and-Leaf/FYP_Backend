package com.fyp.shopingbackend.entity.repository.impl;

import com.fyp.shopingbackend.entity.model.OrderDO;
import com.fyp.shopingbackend.entity.model.OrderDTO;
import com.fyp.shopingbackend.entity.model.OrderProductDO;
import com.fyp.shopingbackend.entity.model.OrderProductDTO;
import com.fyp.shopingbackend.entity.model.ProductDO;
import com.fyp.shopingbackend.entity.model.ProductDTO;
import com.fyp.shopingbackend.entity.model.ShopingDTO;
import com.fyp.shopingbackend.entity.repository.CommonRepositoryService;
import com.fyp.shopingbackend.entity.repository.OrderProductRepository;
import com.fyp.shopingbackend.entity.repository.OrderRepository;
import com.fyp.shopingbackend.entity.repository.ProductRepository;
import com.fyp.shopingbackend.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * central repository service implementation
 */
@Service
public class CommonRepositoryServiceImpl implements CommonRepositoryService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public ProductDTO getProductDTO(String productCode) {

        ProductDO productDO = productRepository.getProductDoByProductCode(productCode);

        if (productDO == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setProductAmount(productDO.getProductAmount());
        dto.setProductCode(productDO.getProductCode());
        dto.setProductCurrency(productDO.getProductCurrency());
        dto.setProductName(productDO.getProductName());
        dto.setProductDescription(productDO.getProductDescription());
        return dto;
    }

    @Override
    public OrderDTO addOrder(String orderCode, String barcode, int quantity) {

        OrderDO orderDO = orderRepository.getOrderDoByOrderCode(orderCode);
        ProductDO productDO = productRepository.getProductDoByProductCode(barcode);

        int amount = productDO.getProductAmount() * quantity;

        if (orderDO == null) {
            orderRepository.createOrderDo(orderCode);
        } else {
            amount += orderDO.getAmount();
        }

        OrderProductDO orderProductDO = orderProductRepository.getOrderProductDoByOrderCodeAndProductCode(orderCode, barcode);
        if (orderProductDO == null) {
            orderProductRepository.insertOrderProductDo(orderCode, barcode, quantity);
        } else {
            orderProductRepository.updateOrderProductDoByOrderCodeAndProductCode(orderCode, barcode, orderProductDO.getQuantity() + quantity);
        }


        orderRepository.updateOrder(orderCode, amount);
        OrderDO temp = orderRepository.getOrderDoByOrderCode(orderCode);

        OrderDTO dto = new OrderDTO();
        dto.setOrderCode(temp.getOrderCode());
        dto.setOrderStatus(temp.getOrderStatus());


        return dto;
    }

    @Override
    public ShopingDTO orderCheckout(String orderCode) {
        List<OrderProductDO> orderProductDOList = orderProductRepository.getOrderProductDoByOrderCode(orderCode);

        OrderDO orderDO = orderRepository.getOrderDoByOrderCode(orderCode);


        List<OrderProductDTO> productDTOList = new ArrayList<>();

        for (OrderProductDO orderProductDO : orderProductDOList) {

            ProductDO productDO = productRepository.getProductDoByProductCode(orderProductDO.getProductCode());

            if (productDO == null) {
                continue;
            }

            OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setProductName(productDO.getProductName());
            orderProductDTO.setQuantity(orderProductDO.getQuantity());
            orderProductDTO.setUnitPrice(productDO.getProductAmount());

            productDTOList.add(orderProductDTO);
        }

        ShopingDTO shopingDTO = new ShopingDTO();
        shopingDTO.setAmount(MoneyUtil.getAmountStr(orderDO.getAmount()));
        shopingDTO.setOrderCode(orderCode);
        shopingDTO.setProductDTOList(productDTOList);

        return shopingDTO;
    }

    @Override
    public boolean payment(String orderCode) {
        orderRepository.payment(orderCode);
        return true;
    }
}
