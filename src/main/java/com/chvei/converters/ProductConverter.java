package com.chvei.converters;

import com.chvei.domain.Product;
import com.chvei.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component

public class ProductConverter {

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTittle(product.getTittle());
        productDto.setPrice(String.format("%.2f$", product.getPrice()));
        return productDto;
    }

    public Product toEntity(ProductDto productDto) throws NullPointerException {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTittle(productDto.getTittle());
        product.setPrice(Float.parseFloat(productDto.getPrice()
                .replaceFirst("\\$", "")
                .replace(",", ".")));
        return product;
    }
}
