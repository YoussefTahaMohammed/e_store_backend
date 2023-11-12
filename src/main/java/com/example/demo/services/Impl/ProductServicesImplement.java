package com.example.demo.services.Impl;


import com.example.demo.entity.*;


import com.example.demo.repository.ProductRepository;
import com.example.demo.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServicesImplement implements ProductServices {
    private final ProductRepository productRepository;

    private final UserServices userServices;

    private final  CartServices cartServices;

    private final ProductCartServices productCartServices;

    private final ProductWishlistServices productWishlistServices;

    private final WishlistServices wishlistServices;


    public Map<String,String> addProduct(ProductEntity product) {
        Map<String,String> result = new HashMap<>();
        this.productRepository.save(product);
        result.put("api_status", "success");
        result.put("message", "Product Added Successfully");
        this.productRepository.save(product);
        return result;
    }

    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }

    public ProductEntity findProductById(Integer id){
        Optional<ProductEntity> returnedProduct = this.productRepository.findById(id);
        return returnedProduct.orElseGet(ProductEntity::new);
    }

    public void addProductToCart(Integer productId,Integer userId){
        UserEntity user = this.userServices.findUserById(userId);
        ProductEntity product = this.findProductById(productId);
        CartEntity cart= this.cartServices.findCartById(user.getCartId());
        cart.setProductNumber(cart.getProductNumber()+1);
        cart.setTotalPrice(cart.getTotalPrice()+product.getPrice());
        productCartServices.addProductToCart(new ProductsCartEntity(productId,user.getCartId()));
    }

    public void addProductToWishlist(Integer productId,Integer userId){
        UserEntity user = this.userServices.findUserById(userId);
        ProductEntity product = this.findProductById(productId);
        WishlistEntity wishlist= this.wishlistServices.findWishlistById(user.getWishlistId());
        wishlist.setProductNumber(wishlist.getProductNumber()+1);
        wishlist.setTotalPrice(wishlist.getTotalPrice()+product.getPrice());
        productWishlistServices.addToWishlist(new ProductsWishlistEntity(productId,user.getWishlistId()));
    }
    @Transactional
    public void deleteProductFromCart(Integer productId,Integer userId){
        UserEntity user = this.userServices.findUserById(userId);
        ProductEntity product = this.findProductById(productId);
        CartEntity cart= this.cartServices.findCartById(user.getCartId());
        cart.setProductNumber(cart.getProductNumber()-1);
        cart.setTotalPrice(cart.getTotalPrice()-product.getPrice());
        productCartServices.deleteProductFromCart(productId,user.getCartId());
    }
}