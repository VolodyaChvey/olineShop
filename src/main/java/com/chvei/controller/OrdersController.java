package com.chvei.controller;

import com.chvei.converters.BasketConvertors;
import com.chvei.converters.OrdersConvertors;
import com.chvei.converters.ProductConverters;
import com.chvei.dto.ProductDto;
import com.chvei.repository.OrdersRepository;
import com.chvei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersConvertors ordersConvertors;
    @Autowired
    private BasketConvertors basketConvertors;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    ProductConverters productConverters;

    public OrdersController() {
    }

    @PostMapping(value = "")
    public ResponseEntity confirmationOfOrder() {
        return ordersService.completedOrders()
                .map(o -> ResponseEntity.ok(ordersConvertors.toDto(o)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders()
                .stream()
                .map(ordersConvertors::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/basketItems")
    public ResponseEntity getBasket() {
        return ResponseEntity.ok(basketConvertors.toDto(ordersService.getBasket()));
    }

    @PostMapping(value = "/basketItems/add")
    public ResponseEntity addItemToBasket(@RequestBody ProductDto productDto) {
        return ordersService.addProduct(productConverters.toEntity(productDto))
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/basketItems/del")
    public ResponseEntity delItemFromBasket(@RequestBody ProductDto productDto) {
        return ordersService.delProduct(productConverters.toEntity(productDto))
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
