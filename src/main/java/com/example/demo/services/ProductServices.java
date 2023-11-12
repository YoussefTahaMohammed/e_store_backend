package com.example.demo.services;


import com.example.demo.entity.*;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
public interface ProductServices {

    Map<String, String> addProduct(ProductEntity product);

    List<ProductEntity> getAllProducts();

    ProductEntity findProductById(Integer id);

    void addProductToCart(Integer productId, Integer userId);

    void addProductToWishlist(Integer productId, Integer userId);

    @Transactional
    void deleteProductFromCart(Integer productId, Integer userId);
}