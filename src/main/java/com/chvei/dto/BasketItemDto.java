package com.chvei.dto;

public class BasketItemDto {
    private String tittle;
    private int quantity;
    private double total;

    public BasketItemDto() {
    }

    public BasketItemDto(String tittle, int quantity, double total) {
        this.tittle = tittle;
        this.quantity = quantity;
        this.total = total;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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
                "tittle='" + tittle + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
