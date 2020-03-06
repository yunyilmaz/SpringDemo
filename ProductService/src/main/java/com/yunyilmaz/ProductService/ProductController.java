package com.yunyilmaz.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/ping")
    public String ping() {
        return "Ping";
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/{productId}")
    public ProductDTO readProductById(@PathVariable("productId") long id) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName("Product" + 1);
        productDTO.setPrice((int) (id * 10.5));

        logger.info("Read product id {0}", productDTO.getId());
        return productDTO;
    }
}
