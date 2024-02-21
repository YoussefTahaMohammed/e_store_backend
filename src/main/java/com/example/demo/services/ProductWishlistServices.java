package com.example.demo.services;


import com.example.demo.model.entity.ProductsWishlist;
import org.springframework.stereotype.Service;

@Service
public interface ProductWishlistServices {

    void addToWishlist(ProductsWishlist productsWishlist);
}