package com.yunyilmaz.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    @PostMapping("/orders")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO requestDTO) {


        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();


        //ProductDTO product = productServiceClient.readProduct(requestDTO.getProductId());

        //CustomerDTO customer = customerServiceClient.readCustomerById(requestDTO.getCustomerId());

        orderResponseDTO.setOrderId(requestDTO.getCustomerId() + "_" + requestDTO.getProductId());

        //orderResponseDTO.setTotalPrice(product.getPrice()*requestDTO.getCount());

        //orderResponseDTO.setMessage("Customer info"+customer.getName()  +",address"+customer.getAddress());

        return orderResponseDTO;
    }

}
