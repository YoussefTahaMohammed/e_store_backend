package com.example.demo.controller;


import com.example.demo.services.OrderServices;
import com.example.demo.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping(path = "/addOrder")
    public OrderEntity addOrder(@RequestBody OrderEntity order){
        return this.orderServices.addOrder(order);
    }
}
