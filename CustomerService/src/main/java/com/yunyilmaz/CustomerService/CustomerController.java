package com.yunyilmaz.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/{customerId}")
    public CustomerDTO readCustomerById(@PathVariable long customerId) {
        CustomerDTO customer = new CustomerDTO();
        customer.setId((int) customerId);
        customer.setAddress("New York / USA");
        customer.setName("Yakup UNYILMAZ");

        return customer;
    }
}
