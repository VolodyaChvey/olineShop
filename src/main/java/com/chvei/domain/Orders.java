package com.chvei.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column
    private double orderPrice;
    @Column
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<BasketItem> items;

    public Orders() {
    }

    public Orders(Long id, double orderPrice, LocalDateTime timestamp, List<BasketItem> items) {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderPrice=" + orderPrice +
                ", timestamp=" + timestamp +
                '}';
    }
}
