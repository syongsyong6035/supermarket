package com.supermarket.product.Dto;

import com.supermarket.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private double price;
    private int quantity;


    public ProductDTO(Product product) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
}
