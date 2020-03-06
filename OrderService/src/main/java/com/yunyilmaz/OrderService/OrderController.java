package com.yunyilmaz.OrderService;

import com.yunyilmaz.OrderService.client.CustomerDTO;
import com.yunyilmaz.OrderService.client.CustomerServiceClient;
import com.yunyilmaz.OrderService.client.ProductDTO;
import com.yunyilmaz.OrderService.client.ProductServiceClient;
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

    @PostMapping("/orders")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO requestDTO) {


        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();


        ProductDTO product = productServiceClient.readProductById(requestDTO.getProductId());

        CustomerDTO customer = customerServiceClient.readCustomerById(requestDTO.getCustomerId());

        orderResponseDTO.setOrderId(requestDTO.getCustomerId() + "__" + requestDTO.getProductId());

        orderResponseDTO.setTotalPrice(product.getPrice() * requestDTO.getCount());

        orderResponseDTO.setMessage("Customer info" + customer.getName() + ",address" + customer.getAddress());

        return orderResponseDTO;
    }

}
