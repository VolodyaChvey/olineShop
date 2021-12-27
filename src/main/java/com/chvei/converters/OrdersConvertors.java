package com.chvei.converters;

import com.chvei.domain.Orders;
import com.chvei.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrdersConvertors {
    private ItemConvertors itemConvertors;

    public OrdersConvertors() {
    }

    @Autowired
    public OrdersConvertors(ItemConvertors itemConvertors) {
        this.itemConvertors = itemConvertors;
    }

    public OrdersDto toDto(Orders orders) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId(orders.getId());
        ordersDto.setOrderPrice(orders.getOrderPrice());
        ordersDto.setTimestamp(orders.getTimestamp().toString());
        ordersDto.setItems(orders.getItems().stream().map(itemConvertors::toItemDto)
                .collect(Collectors.toList()));
        return ordersDto;
    }
}
