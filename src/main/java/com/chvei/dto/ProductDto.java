package com.chvei.dto;

import java.util.Objects;

public class ProductDto {
    private int id;
    private String tittle;
    private String price;

    public ProductDto() {
    }

    public ProductDto(int id, String tittle, String price) {
        this.id = id;
        this.tittle = tittle;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id &&
                tittle.equals(that.tittle) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, price);
    }
}
