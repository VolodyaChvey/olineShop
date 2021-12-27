package com.chvei.service;

import com.chvei.domain.BasketItem;
import com.chvei.domain.Orders;
import com.chvei.domain.Product;
import com.chvei.repository.BasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BasketService {
    @Autowired
    private BasketItemRepository basketItemRepository;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;

    public List<BasketItem> getBasket() {
        return basketItemRepository.findAllBasketItem(ordersService.getOrdersOrCreatOrders().getId());
    }

    public List<BasketItem> getBasket(Long idOrders) {
        return basketItemRepository.findAllBasketItem(idOrders);
    }

    public boolean addProductInBasket(Product product) {
        if (validProduct(product)) {
            Orders order = ordersService.getOrdersOrCreatOrders();
            order.getItems().stream()
                    .filter(b -> b.getProduct().equals(product))
                    .findFirst()
                    .map(b -> changeQuantity(b, 1))
                    .orElseGet(() -> creatBasketItem(product, order));
            return true;
        }
        return false;
    }

    public boolean deleteProductInBasket(Product product) {
        if (validProduct(product)) {
            Orders order = ordersService.getOrdersOrCreatOrders();
            Optional<BasketItem> optionalBasketItem = order.getItems().stream()
                    .filter(b -> b.getProduct().equals(product))
                    .findFirst();
            if (optionalBasketItem.isPresent()) {
                BasketItem basketItem = optionalBasketItem.get();
                if (basketItem.getQuantity() > 1) {
                    changeQuantity(basketItem, -1);
                } else {
                    basketItem.setOrders(null);
                }
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    private BasketItem creatBasketItem(Product product, Orders orders) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProduct(product);
        basketItem.setQuantity(1);
        basketItem.setTotal(Math.round((double) product.getPrice() * 100) / 100.00);
        basketItem.setOrders(orders);
        basketItem.setId(basketItemRepository.saveBasketItem(basketItem));
        return basketItem;
    }

    private BasketItem changeQuantity(BasketItem basketItem, int i) {
        basketItem.setQuantity(basketItem.getQuantity() + i);
        basketItem.setTotal(Math.round((double) (basketItem.getProduct().getPrice() * basketItem.getQuantity()) * 100) / 100.00);
        return basketItem;
    }

    private boolean validProduct(Product product) {
        Optional<Product> optionalProduct = productService.getProductById(product.getId());
        return optionalProduct.isPresent() && optionalProduct.get().equals(product);
    }
}
