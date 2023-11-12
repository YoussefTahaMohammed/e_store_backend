package com.example.demo.services;

import com.example.demo.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderServices {
    OrderEntity addOrder(OrderEntity brand);
}
