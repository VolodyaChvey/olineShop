package com.chvei.repository;

import com.chvei.domain.BasketItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BasketItemRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Long saveBasketItem(BasketItem basketItem) {
        return (Long) sessionFactory.getCurrentSession()
                .save(basketItem);
    }

    public List<BasketItem> findAllBasketItem(Long idOrders) {
        return sessionFactory.getCurrentSession()
                .createQuery("from BasketItem where orders_id=:id")
                .setParameter("id", idOrders)
                .getResultList();
    }
}
