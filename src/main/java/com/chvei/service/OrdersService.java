package com.chvei.service;

import com.chvei.domain.Orders;
import com.chvei.domain.Product;
import com.chvei.domain.User;
import com.chvei.exceptions.UserNotFoundException;
import com.chvei.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
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
    private UserService userService;

    public OrdersService() {
    }

    public Optional<List<Orders>> getAllOrdersByUser(Principal principal) {
        User user = userService.getCurrentUser(principal).orElse(null);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(ordersRepository.findAllOrdersByUserId(user.getId()));
    }

    public Optional<List<Object[]>> getBasket(Principal principal) {
        User user = userService.getCurrentUser(principal).orElse(null);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(ordersRepository.findBasket(getOrdersOrCreatOrders(user).getId()));
    }

    public List<Object[]> getBasket(Long idOrders) {
        return ordersRepository.findBasket(idOrders);
    }

    public Optional<Orders> completedOrders(Principal principal) {
        User user = userService.getCurrentUser(principal).orElse(null);
        if (user == null) {
            return Optional.empty();
        }
        Orders order = getOrdersOrCreatOrders(user);
        if (!order.getProductList().isEmpty()) {
            order.setOrderPrice(Math.round(order.getProductList().stream()
                    .mapToDouble(Product::getPrice)
                    .sum() * 100) / 100.00);
            order.setTimestamp(LocalDateTime.now());
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public boolean addProduct(Product product, Principal principal) throws UserNotFoundException {
        User user = userService.getCurrentUser(principal)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Orders orders = getOrdersOrCreatOrders(user);
        return validProduct(product) && orders.getProductList().add(product);
    }

    public boolean delProduct(Product product, Principal principal) throws UserNotFoundException {
        User user = userService.getCurrentUser(principal)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Orders orders = getOrdersOrCreatOrders(user);
        return validProduct(product) && orders.getProductList().remove(product);
    }

    private Orders createOrders(User user) {
        Orders orders = new Orders();
        orders.setUser(user);
        orders.setId(ordersRepository.saveOrders(orders));
        orders.setProductList(new ArrayList<>());
        return orders;
    }

    public Orders getOrdersOrCreatOrders(User user) {
        return ordersRepository.findOrderByNullByUserId(user.getId())
                .orElseGet(() -> createOrders(user));
    }

    private boolean validProduct(Product product) {
        Optional<Product> optionalProduct = productService.getProductById(product.getId());
        return optionalProduct.isPresent() && optionalProduct.get().equals(product);
    }
}
