package com.example.demo.services;

import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity addOrder(OrderEntity brand){
        return this.orderRepository.save(brand);
    }
}
