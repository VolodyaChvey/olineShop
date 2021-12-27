package com.chvei.controller;

import com.chvei.converters.ProductConverters;
import com.chvei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductConverters productConverters;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductService productService, ProductConverters productConverters) {
        this.productService = productService;
        this.productConverters = productConverters;
    }

    @GetMapping(value = "")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts().stream()
                .map(productConverters::toDto).collect(Collectors.toList()));
    }

}
