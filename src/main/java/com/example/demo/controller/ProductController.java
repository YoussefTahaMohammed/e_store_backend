package com.example.demo.controller;



import com.example.demo.services.ProductServices;

import com.example.demo.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping(path = "/addProduct")
    public Map<String, String> addProduct(@RequestBody ProductEntity product){
        return this.productServices.addProduct(product);
    }

    @GetMapping(path = "/getAllProducts")
    public List<ProductEntity> getAllProducts(){
        return this.productServices.getAllProducts();
    }
}
