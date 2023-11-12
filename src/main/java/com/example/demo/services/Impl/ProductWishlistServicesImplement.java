package com.example.demo.services.Impl;


import com.example.demo.entity.ProductsWishlistEntity;
import com.example.demo.repository.ProductsWishlistRepository;
import com.example.demo.services.ProductWishlistServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductWishlistServicesImplement implements ProductWishlistServices {

    private final ProductsWishlistRepository productWishlistRepository;
    public void addToWishlist(ProductsWishlistEntity productsWishlist){
        this.productWishlistRepository.save(productsWishlist);
    }
}