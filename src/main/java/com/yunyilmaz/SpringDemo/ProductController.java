package com.yunyilmaz.SpringDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/ping")
    public String ping() {
        return "Ping";
    }
}
