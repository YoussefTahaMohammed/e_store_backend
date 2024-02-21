package com.example.demo.services;

import com.example.demo.model.entity.Cart;
import org.springframework.stereotype.Service;


@Service
public interface CartServices {
    Cart addCart(Cart cart);
    Cart findCartById(Integer cartId);
    void deleteCartById(Integer id);

}