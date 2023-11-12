package com.example.demo.controller;


import com.example.demo.entity.ProductEntity;
import com.example.demo.services.ProductServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductServices productServices;

    @PostMapping(path = "/addProduct")
    public Map<String, String> addProduct(@RequestBody ProductEntity product) {
        return this.productServices.addProduct(product);
    }

    @GetMapping(path = "/getAllProducts")
    public List<ProductEntity> getAllProducts() {
        return this.productServices.getAllProducts();
    }

    @GetMapping(path = "/addProductToCart")
    public void addProductToCart(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.addProductToCart(productId, userId);
    }

    @GetMapping(path = "/addProductToWishlist")
    public void addProductToWishlist(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.addProductToWishlist(productId, userId);
    }

    @DeleteMapping(path = "/deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.deleteProductFromCart(productId, userId);
    }
}
