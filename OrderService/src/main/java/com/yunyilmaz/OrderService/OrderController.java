package com.yunyilmaz.OrderService;

import com.yunyilmaz.OrderService.client.CustomerDTO;
import com.yunyilmaz.OrderService.client.CustomerServiceClient;
import com.yunyilmaz.OrderService.client.ProductDTO;
import com.yunyilmaz.OrderService.client.ProductServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private CustomerServiceClient customerServiceClient;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/orders")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO requestDTO) {

        logger.info(requestDTO.toString());
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();


        ProductDTO product = productServiceClient.readProductById(requestDTO.getProductId());

        CustomerDTO customer = customerServiceClient.readCustomerById(requestDTO.getCustomerId());

        orderResponseDTO.setOrderId(requestDTO.getCustomerId() + "__" + requestDTO.getProductId());

        orderResponseDTO.setTotalPrice(product.getPrice() * requestDTO.getCount());

        orderResponseDTO.setMessage("Customer info" + customer.getName() + ",address" + customer.getAddress());

        return orderResponseDTO;
    }

}
