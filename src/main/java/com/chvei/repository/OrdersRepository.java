package com.chvei.repository;

import com.chvei.domain.Orders;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class OrdersRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Long saveOrders(Orders orders) {
        return (Long) sessionFactory.getCurrentSession()
                .save(orders);
    }

    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Orders where timestamp is Not Null")
                .getResultList();
    }

    public Optional<Orders> findOrderByNull() {
        return (Optional<Orders>) sessionFactory.getCurrentSession()
                .createQuery("from Orders where timestamp is Null")
                .getResultStream()
                .findFirst();
    }

    public List<Object[]> findBasket(Long idOrders){
        return sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT P.id, P.tittle, P.price, COUNT(*), SUM(P.price) " +
                        "FROM Product AS P JOIN orders_product AS O_P ON O_P.product_id = P.id " +
                        "WHERE O_P.orders_id =:idOrders " +
                        "GROUP BY P.id")
                .setParameter("idOrders",idOrders)
                .getResultList();
    }
}
