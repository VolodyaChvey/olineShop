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

    public List<Orders> findAllOrdersByUserId(int userId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Orders where timestamp is Not Null and user_id=:userId")
                .setParameter("userId",userId)
                .getResultList();
    }

    public Optional<Orders> findOrderByNullByUserId(int userId) {
        return (Optional<Orders>) sessionFactory.getCurrentSession()
                .createQuery("from Orders where timestamp is Null and user_id=:userId")
                .setParameter("userId",userId)
                .getResultStream()
                .findFirst();
    }

    public List<Object[]> findBasket(Long ordersId){
        return sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT P.id, P.tittle, P.price, COUNT(*), SUM(P.price) " +
                        "FROM Product AS P JOIN orders_product AS O_P ON O_P.product_id = P.id " +
                        "WHERE O_P.orders_id =:idOrders " +
                        "GROUP BY P.id")
                .setParameter("idOrders",ordersId)
                .getResultList();
    }
}
