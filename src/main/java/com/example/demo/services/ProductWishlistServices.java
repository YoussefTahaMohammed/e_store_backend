package com.example.demo.services;


import com.example.demo.entity.ProductsWishlistEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductWishlistServices {

    void addToWishlist(ProductsWishlistEntity productsWishlist);
}