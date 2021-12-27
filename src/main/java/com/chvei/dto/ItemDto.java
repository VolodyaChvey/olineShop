package com.chvei.dto;

import java.util.Objects;

public class ItemDto {
    private Long id;
    private String tittle;
    private float price;
    private int quantity;
    private Double total;

    public ItemDto() {
    }

    public ItemDto(Long id, String tittle, float price, int quantity, Double total) {
        this.id = id;
        this.tittle = tittle;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return Float.compare(itemDto.price, price) == 0 &&
                quantity == itemDto.quantity &&
                id.equals(itemDto.id) &&
                tittle.equals(itemDto.tittle) &&
                total.equals(itemDto.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, price, quantity, total);
    }
}
