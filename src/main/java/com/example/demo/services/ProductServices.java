package com.example.demo.services;


import com.example.demo.entity.ProductEntity;


import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity addProduct(ProductEntity product) {
        //Map<String,String> result = new HashMap<>();
        this.productRepository.save(product);
        //result.put("api_status", "success");
        //result.put("message", "Product Added Successfully");
        return this.productRepository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }
}
