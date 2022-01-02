package com.chvei.dto;

import java.util.List;
import java.util.Objects;

public class OrdersDto {
    private Long id;
    private double orderPrice;
    private String timestamp;
    private UserDto userDto;
    private List<BasketItemDto> items;

    public OrdersDto() {
    }

    public OrdersDto(Long id, double orderPrice, String timestamp, UserDto userDto, List<BasketItemDto> items) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.timestamp = timestamp;
        this.userDto = userDto;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<BasketItemDto> getItems() {
        return items;
    }

    public void setItems(List<BasketItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrdersDto{" +
                "id=" + id +
                ", orderPrice=" + orderPrice +
                ", timestamp='" + timestamp + '\'' +
                ", userDto=" + userDto +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDto ordersDto = (OrdersDto) o;
        return Double.compare(ordersDto.orderPrice, orderPrice) == 0 &&
                id.equals(ordersDto.id) &&
                timestamp.equals(ordersDto.timestamp) &&
                userDto.equals(ordersDto.userDto) &&
                items.equals(ordersDto.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderPrice, timestamp, userDto, items);
    }
}
