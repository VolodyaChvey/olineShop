package com.chvei.repository;

import com.chvei.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> findAllProducts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product")
                .getResultList();
    }

    public Optional<Product> findProductById(int idProduct) {
        return (Optional<Product>) sessionFactory.getCurrentSession()
                .createQuery("from Product where id=:id")
                .setParameter("id", idProduct)
                .getResultStream()
                .findFirst();
    }
}
