package com.yunyilmaz.OrderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductServiceClient {

	@GetMapping("/product/{productId}")
	public ProductDTO readProductById(@PathVariable("productId") int id);
}
