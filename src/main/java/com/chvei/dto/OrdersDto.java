package com.chvei.dto;

import java.util.List;
import java.util.Objects;

public class OrdersDto {
    private Long id;
    private double orderPrice;
    private String timestamp;
    private List<BasketItemDto> items;

    public OrdersDto() {
    }

    public OrdersDto(Long id, double orderPrice, String timestamp, List<BasketItemDto> items) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.timestamp = timestamp;
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
                ", items=" + items +
                '}';
    }
}
