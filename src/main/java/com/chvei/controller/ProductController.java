package com.chvei.controller;

import com.chvei.converters.ProductConverter;
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
    private ProductConverter productConverter;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @GetMapping(value = "")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts().stream()
                .map(productConverter::toDto).collect(Collectors.toList()));
    }

}
