package com.chvei.service;

import com.chvei.converters.BasketConvertors;
import com.chvei.domain.Orders;
import com.chvei.domain.Product;
import com.chvei.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    BasketConvertors basketConvertors;

    public OrdersService() {
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAllOrders();
    }

    public List<Object[]> getBasket() {
        return ordersRepository.findBasket(getOrdersOrCreatOrders().getId());
    }

    public List<Object[]> getBasket(Long idOrders) {
        return ordersRepository.findBasket(idOrders);
    }

    public Optional<Orders> completedOrders() {
        Orders order = getOrdersOrCreatOrders();
        System.out.println("completdOrders: " + order);
        if (!order.getProductList().isEmpty()) {
            order.setOrderPrice(Math.round(order.getProductList().stream()
                    .mapToDouble(Product::getPrice)
                    .sum()*100)/100.00);
            order.setTimestamp(LocalDateTime.now());
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public boolean addProduct(Product product) {
        Orders orders = getOrdersOrCreatOrders();
        return validProduct(product) && orders.getProductList().add(product);
    }

    public boolean delProduct(Product product) {
        Orders orders = getOrdersOrCreatOrders();
        return validProduct(product) && orders.getProductList().remove(product);
    }

    private Orders creatOrders() {
        Orders orders = new Orders();
        orders.setId(ordersRepository.saveOrders(orders));
        if (orders.getProductList() == null) {
            orders.setProductList(new ArrayList<>());
        }
        return orders;
    }

    public Orders getOrdersOrCreatOrders() {
        return ordersRepository.findOrderByNull()
                .orElseGet(this::creatOrders);
    }

    private boolean validProduct(Product product) {
        Optional<Product> optionalProduct = productService.getProductById(product.getId());
        return optionalProduct.isPresent() && optionalProduct.get().equals(product);
    }
}
