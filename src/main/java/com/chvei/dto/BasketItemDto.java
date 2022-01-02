package com.chvei.dto;

import java.util.Objects;

public class BasketItemDto {
    private int productId;
    private String tittle;
    private Float price;
    private int quantity;
    private double total;

    public BasketItemDto() {
    }

    public BasketItemDto(int productId, String tittle, Float price, int quantity, double total) {
        this.productId = productId;
        this.tittle = tittle;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BasketItemDto{" +
                "productId=" + productId +
                ", tittle='" + tittle + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItemDto that = (BasketItemDto) o;
        return productId == that.productId &&
                quantity == that.quantity &&
                Double.compare(that.total, total) == 0 &&
                tittle.equals(that.tittle) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, tittle, price, quantity, total);
    }
}
