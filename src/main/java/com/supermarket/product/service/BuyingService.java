package com.supermarket.product.service;

import com.supermarket.entity.Product;
import com.supermarket.product.Dto.ProductDTO;
import com.supermarket.product.ProductRepository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyingService {

    private final ProductRepository buyingRepository;

    public BuyingService(ProductRepository buyingRepository) {
        this.buyingRepository = buyingRepository;
    }

    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        buyingRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return buyingRepository.findAll();
    }


    public Optional<Product> findPostById(Long id) {
        return buyingRepository.findById(id);
    }
    public void updateProduct(Long id, ProductDTO productDTO) {
        Product product = buyingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));


        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        buyingRepository.save(product); // 업데이트된 상품 저장
    }

    public void deleteProduct(Long id) {
        buyingRepository.deleteById(id);
    }
}
