package com.chvei.service;

import com.chvei.domain.BasketItem;
import com.chvei.domain.Orders;
import com.chvei.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersService {
    private OrdersRepository ordersRepository;
    private BasketService basketService;

    public OrdersService() {
    }

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, BasketService basketService) {
        this.ordersRepository = ordersRepository;
        this.basketService = basketService;
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAllOrders();
    }

    public Optional<Orders> completedOrders() {
        Orders order = getOrdersOrCreatOrders();
        if (!order.getItems().isEmpty()) {
            order.setOrderPrice(order.getItems().stream()
                    .mapToDouble(BasketItem::getTotal)
                    .sum());
            order.setTimestamp(LocalDateTime.now());
            return Optional.of(order);
        }
        return Optional.empty();
    }

    private Orders creatOrders() {
        Orders orders = new Orders();
        orders.setId(ordersRepository.saveOrders(orders));
        return orders;
    }

    public Orders getOrdersOrCreatOrders() {
        Orders orders = ordersRepository.findOrderByNull()
                .orElseGet(() -> creatOrders());
        orders.setItems(basketService.getBasket(orders.getId()));
        return orders;
    }

}
