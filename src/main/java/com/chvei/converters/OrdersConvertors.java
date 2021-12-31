package com.chvei.converters;

import com.chvei.domain.Orders;
import com.chvei.dto.OrdersDto;
import com.chvei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrdersConvertors {
@Autowired
private OrdersService ordersService;
@Autowired
private BasketConvertors basketConvertors;

    public OrdersConvertors() {
    }

    public OrdersDto toDto(Orders orders) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId(orders.getId());
        ordersDto.setOrderPrice(orders.getOrderPrice());
        ordersDto.setTimestamp(orders.getTimestamp().toString());
        ordersDto.setItems(basketConvertors.toDto(ordersService.getBasket(orders.getId())));
        return ordersDto;
    }
}
