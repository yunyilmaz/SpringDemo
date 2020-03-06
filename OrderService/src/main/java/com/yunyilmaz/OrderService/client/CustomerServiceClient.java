package com.yunyilmaz.OrderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerServiceClient {


	@GetMapping("/customer/{customerId}")
	public CustomerDTO readCustomerById(@PathVariable("customerId") int id);


}
