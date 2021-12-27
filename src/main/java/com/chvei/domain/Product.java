package com.chvei.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private String tittle;

    @Column(nullable = false)
    private float price;

    public Product() {
    }

    public Product(int id, String tittle, float price) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price, price) == 0 &&
                tittle.equals(product.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, price);
    }
}
