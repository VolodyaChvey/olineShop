package com.chvei.domain;

import javax.persistence.*;

@Entity
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double total;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public BasketItem() {
    }

    public BasketItem(Long id, Product product, int quantity, Double total, Orders orders) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orders=" + orders +
                '}';
    }
}
