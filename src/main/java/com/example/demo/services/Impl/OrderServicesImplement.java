package com.example.demo.services.Impl;

import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderRepository;
import com.example.demo.services.OrderServices;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServicesImplement implements OrderServices {
    private final OrderRepository orderRepository;

    public OrderEntity addOrder(OrderEntity brand){
        return this.orderRepository.save(brand);
    }
}
