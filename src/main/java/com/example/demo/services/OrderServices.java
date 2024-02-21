package com.example.demo.services;

import com.example.demo.model.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderServices {
    Order addOrder(Order brand);
}
