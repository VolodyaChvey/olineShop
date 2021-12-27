package com.chvei.controller;

import com.chvei.converters.OrdersConvertors;
import com.chvei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService ordersService;
    private OrdersConvertors ordersConvertors;

    public OrdersController() {
    }

    @Autowired
    public OrdersController(OrdersService ordersService, OrdersConvertors ordersConvertors) {
        this.ordersService = ordersService;
        this.ordersConvertors = ordersConvertors;
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
}
