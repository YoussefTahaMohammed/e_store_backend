package com.example.demo.services.Impl;

import com.example.demo.entity.CartEntity;
import com.example.demo.repository.CartRepository;
import com.example.demo.services.CartServices;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServicesImplement implements CartServices {
    private final CartRepository cartRepository;

    public CartEntity addCart(CartEntity cart){
        return cartRepository.save(cart);
    }
    public CartEntity findCartById(Integer cartId){
        Optional<CartEntity> returnedCart = this.cartRepository.findById(cartId);
        return returnedCart.orElseGet(CartEntity::new);
    }
    public void deleteCartById(Integer id){
        cartRepository.deleteById(id);
    }

}