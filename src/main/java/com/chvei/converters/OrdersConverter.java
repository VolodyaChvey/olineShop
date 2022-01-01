package com.chvei.converters;

import com.chvei.domain.Orders;
import com.chvei.dto.OrdersDto;
import com.chvei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrdersConverter {
@Autowired
private OrdersService ordersService;
@Autowired
private BasketConverter basketConverter;
@Autowired
private UserConverter userConverter;

    public OrdersConverter() {
    }

    public OrdersDto toDto(Orders orders) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId(orders.getId());
        ordersDto.setOrderPrice(orders.getOrderPrice());
        ordersDto.setTimestamp(orders.getTimestamp().toString());
        ordersDto.setUserDto(userConverter.toDto(orders.getUser()));
        ordersDto.setItems(basketConverter.toDto(ordersService.getBasket(orders.getId())));
        return ordersDto;
    }
}
