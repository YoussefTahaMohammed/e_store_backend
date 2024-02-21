package com.example.demo.services;

import com.example.demo.model.entity.ProductsCart;
import org.springframework.stereotype.Service;


@Service
public interface ProductCartServices {
    void addProductToCart(ProductsCart productsCart);

    void deleteProductFromCart(Integer productId, Integer cartId);
}
