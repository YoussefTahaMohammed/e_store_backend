package com.example.demo.controller;



import com.example.demo.model.entity.Order;
import com.example.demo.services.OrderServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderServices orderServices;

    @PostMapping(path = "/addOrder")
    public Order addOrder(@RequestBody Order order){
        return this.orderServices.addOrder(order);
    }
}
