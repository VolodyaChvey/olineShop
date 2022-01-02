package com.chvei.controller;

import com.chvei.converters.BasketConverter;
import com.chvei.converters.OrdersConverter;
import com.chvei.converters.ProductConverter;
import com.chvei.dto.ProductDto;
import com.chvei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersConverter ordersConverter;
    @Autowired
    private BasketConverter basketConverter;
    @Autowired
    ProductConverter productConverter;

    public OrdersController() {
    }

    @PostMapping(value = "")
    public ResponseEntity confirmationOfOrder(Principal principal) {
        return ordersService.completedOrders(principal)
                .map(o -> ResponseEntity.ok(ordersConverter.toDto(o)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "")
    public ResponseEntity getAllOrdersByUser(Principal principal) {
        return ordersService.getAllOrdersByUser(principal)
                .map(listO -> ResponseEntity.ok(listO.stream()
                        .map(ordersConverter::toDto)
                        .collect(Collectors.toList())))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/basketItems")
    public ResponseEntity getBasket(Principal principal) {
        return ordersService.getBasket(principal)
                .map(b -> ResponseEntity.ok(basketConverter.toDto(b)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/basketItems/add")
    public ResponseEntity addItemToBasket(@RequestBody ProductDto productDto, Principal principal) {
        try {
            return ordersService.addProduct(productConverter.toEntity(productDto), principal)
                    ? new ResponseEntity(HttpStatus.OK)
                    : new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/basketItems/del")
    public ResponseEntity delItemFromBasket(@RequestBody ProductDto productDto, Principal principal) {
        try {
            return ordersService.delProduct(productConverter.toEntity(productDto), principal)
                    ? new ResponseEntity(HttpStatus.OK)
                    : new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
