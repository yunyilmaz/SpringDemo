package com.yunyilmaz.SpringDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/ping")
    public String ping() {
        return "Ping";
    }

    @GetMapping("/{productId}")
    public ProductDTO readProductById (@PathVariable("productId") long id){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName("Product" + 1);
        productDTO.setPrice((int) (id * 10.5));

        return productDTO;
    }
}
