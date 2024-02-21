package com.example.demo.services.Impl;

import com.example.demo.model.entity.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.services.CartServices;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServicesImplement implements CartServices {
    private final CartRepository cartRepository;

    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }
    public Cart findCartById(Integer cartId){
        Optional<Cart> returnedCart = this.cartRepository.findById(cartId);
        return returnedCart.orElseGet(Cart::new);
    }
    public void deleteCartById(Integer id){
        cartRepository.deleteById(id);
    }

}