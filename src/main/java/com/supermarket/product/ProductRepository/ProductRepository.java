package com.supermarket.product.ProductRepository;

import com.supermarket.entity.Product;
import com.supermarket.product.Dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
