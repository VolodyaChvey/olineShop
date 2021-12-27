package com.chvei.controller;

import com.chvei.converters.BasketItemConverters;
import com.chvei.converters.ProductConverters;
import com.chvei.dto.ProductDto;
import com.chvei.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/basketItems")
public class BasketController {
    private BasketService basketService;
    private BasketItemConverters basketItemConverters;
    private ProductConverters productConverters;

    @Autowired
    public BasketController(BasketService basketService, BasketItemConverters basketItemConverters, ProductConverters productConverters) {
        this.basketService = basketService;
        this.basketItemConverters = basketItemConverters;
        this.productConverters = productConverters;
    }

    @GetMapping(value = "")
    public ResponseEntity getBasket() {
        return ResponseEntity.ok(basketService.getBasket().stream()
                .map(basketItemConverters::toDto)
                .collect(Collectors.toList()));
    }

    @PostMapping("/addProduct")
    public ResponseEntity addBasket(@RequestBody ProductDto productDto) {
        return basketService.addProductInBasket(productConverters.toEntity(productDto))
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delProduct")
    public ResponseEntity decreaseBasket(@RequestBody ProductDto productDto) {
        return basketService.deleteProductInBasket(productConverters.toEntity(productDto))
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
