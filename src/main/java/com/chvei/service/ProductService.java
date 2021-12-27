package com.chvei.service;

import com.chvei.domain.Product;
import com.chvei.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
    }

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public Optional<Product> getProductById(int idProduct) {
        return productRepository.findProductById(idProduct);
    }
}
