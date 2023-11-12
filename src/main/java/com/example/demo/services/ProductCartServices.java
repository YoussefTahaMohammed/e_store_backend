package com.example.demo.services;

import com.example.demo.entity.ProductsCartEntity;
import org.springframework.stereotype.Service;


@Service
public interface ProductCartServices {
    void addProductToCart(ProductsCartEntity productsCart);

    void deleteProductFromCart(Integer productId, Integer cartId);
}
