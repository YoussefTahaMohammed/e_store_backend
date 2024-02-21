package com.example.demo.controller;


import com.example.demo.model.dto.ProductReqDTO;
import com.example.demo.model.dto.ProductResDTO;
import com.example.demo.model.dto.ProductUpdateReqDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.services.ProductServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductServices productServices;


    @PostMapping(path = "/addProduct")
    public ProductResDTO addProduct(@RequestBody ProductReqDTO product) {
        return this.productServices.addProduct(product);
    }
    @PutMapping(path = "/updateProduct")
    public ProductResDTO updateProduct(@RequestBody ProductUpdateReqDTO product) {
        return this.productServices.updateProduct(product);
    }

    @GetMapping(path = "/getAllProducts")
    public List<ProductResDTO> getAllProducts() {
        return this.productServices.getAllProducts();
    }

    @GetMapping(path = "/addProductToCart")
    public void addProductToCart(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.addProductToCart(productId, userId);
    }

    @GetMapping(path = "/addProductToWishlist")
    public void addProductToWishlist(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.addProductToWishlist(productId, userId);
    }

    @DeleteMapping(path = "/deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Integer productId, @RequestParam Integer userId) {
        this.productServices.deleteProductFromCart(productId, userId);
    }
}
