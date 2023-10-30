package com.example.demo.services;

import com.example.demo.entity.CartEntity;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServices {
    @Autowired
    CartRepository cartRepository;

    public CartEntity addCart(CartEntity cart){
        return cartRepository.save(cart);
    }
    public Optional<CartEntity> findCartById(Integer wishlistId){
        return cartRepository.findById(wishlistId);
    }
    public void deleteCartById(Integer id){
        cartRepository.deleteById(id);
    }
}