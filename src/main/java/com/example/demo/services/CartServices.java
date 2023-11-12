package com.example.demo.services;

import com.example.demo.entity.CartEntity;
import org.springframework.stereotype.Service;


@Service
public interface CartServices {
    CartEntity addCart(CartEntity cart);
    CartEntity findCartById(Integer cartId);
    void deleteCartById(Integer id);

}