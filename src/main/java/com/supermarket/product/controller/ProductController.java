package com.supermarket.product.controller;

import com.supermarket.entity.Product;
import com.supermarket.product.Dto.ProductDTO;
import com.supermarket.product.ProductRepository.ProductRepository;
import com.supermarket.product.service.BuyingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final BuyingService productService;

    public ProductController(BuyingService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "productList";
    }

    @GetMapping("/product/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("product", new Product());
        return "productRegister";
    }
    //글 목록 보여주는것

    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable Long id, Model model) {
        // 상품 ID에 해당하는 상품 정보를 가져온다.
        Product product = productService.findPostById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        model.addAttribute("product", product);
        return "productview";
    }


    @PostMapping("/product/register")
    public String registerProduct(ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return "redirect:/products"; // 등록 후 상품 목록으로 리다이렉트
    }


    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findPostById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "productEdit";
    }

    @PostMapping("/product/edit/{id}")
    public String updateProduct(@PathVariable Long id, ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return "redirect:/products";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products"; // 삭제 후 상품 목록으로 리다이렉트
    }
}

