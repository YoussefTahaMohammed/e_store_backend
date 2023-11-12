package com.example.demo.services.Impl;

import com.example.demo.entity.ProductsCartEntity;
import com.example.demo.repository.ProductCartRepository;
import com.example.demo.services.ProductCartServices;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductCartServicesImplement implements ProductCartServices {
    private final ProductCartRepository productCartRepository;
    public void addProductToCart(ProductsCartEntity productsCart){
        this.productCartRepository.save(productsCart);
    }
    public void deleteProductFromCart(Integer productId,Integer cartId){
        this.productCartRepository.deleteByProductIdAndCartId(productId,cartId);
    }
}
