package com.example.demo.services.Impl;


import com.example.demo.model.dto.ProductReqDTO;

import com.example.demo.model.dto.ProductResDTO;
import com.example.demo.model.dto.ProductUpdateReqDTO;
import com.example.demo.model.entity.*;


import com.example.demo.model.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServicesImplement implements ProductServices {
    private final ProductRepository productRepository;

    private final UserServices userServices;
    private final CategoryServices categoryServices;

    private final  CartServices cartServices;
    private final  BrandServices brandServices;

    private final ProductCartServices productCartServices;

    private final ProductWishlistServices productWishlistServices;

    private final WishlistServices wishlistServices;
    private final ProductMapper productMapper;

    public ProductResDTO addProduct(ProductReqDTO productDTO) {
        Product product = this.productMapper.toEntity(productDTO);
        Category category = categoryServices.findCategoryById(product.getCategoryId());
        Brand brand = brandServices.findBrandById(product.getBrandId());
        product.setCategory(category);
        product.setBrand(brand);
        Product savedProduct = this.productRepository.save(product);
        ProductResDTO productResDTO = this.productMapper.toResDTO(savedProduct);
        productResDTO.setCategoryName(category.getCategoryName());
        productResDTO.setBrandName(brand.getBrandName());
        return productResDTO;
    }

    public ProductResDTO updateProduct(ProductUpdateReqDTO productUpdateReqDTO) {
        Product product = this.productMapper.toEntity(productUpdateReqDTO);
        Category category = categoryServices.findCategoryById(product.getCategoryId());
        Brand brand = brandServices.findBrandById(product.getBrandId());
        product.setCategory(category);
        product.setBrand(brand);
        //Product savedProduct =
        this.productRepository.save(product);
        ProductResDTO productResDTO = this.productMapper.toResDTO(product);
        productResDTO.setCategoryName(category.getCategoryName());
        productResDTO.setBrandName(brand.getBrandName());
        return productResDTO;
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<Product>product =this.productRepository.findById(id);
        if (product.isPresent()){
            product.get().setDeletedAt(LocalDateTime.now());
            this.productRepository.save(product.get());
        }
    }

    public List<ProductResDTO> getAllProducts() {
        List<ProductResDTO> result = new ArrayList<>();
        List<Product> allProducts = this.productRepository.findAll();
        for (Product product : allProducts) {
            Category category = categoryServices.findCategoryById(product.getCategoryId());
            Brand brand = brandServices.findBrandById(product.getBrandId());
            product.setCategory(category);
            product.setBrand(brand);
            ProductResDTO productResDTO = this.productMapper.toResDTO(product);
            productResDTO.setCategoryName(category.getCategoryName());
            productResDTO.setBrandName(brand.getBrandName());
            result.add(productResDTO);
        }
        return result;
    }

    public Product findProductById(Integer id){
        Optional<Product> returnedProduct = this.productRepository.findById(id);
        return returnedProduct.orElseGet(Product::new);
    }

    public void addProductToCart(Integer productId,Integer userId){
        User user = this.userServices.findUserById(userId);
        Product product = this.findProductById(productId);
        Cart cart= this.cartServices.findCartById(user.getCartId());
        cart.setProductNumber(cart.getProductNumber()+1);
        cart.setTotalPrice(cart.getTotalPrice()+product.getPrice());
        productCartServices.addProductToCart(new ProductsCart(productId,user.getCartId()));
    }

    public void addProductToWishlist(Integer productId,Integer userId){
        User user = this.userServices.findUserById(userId);
        Product product = this.findProductById(productId);
        Wishlist wishlist= this.wishlistServices.findWishlistById(user.getWishlistId());
        wishlist.setProductNumber(wishlist.getProductNumber()+1);
        wishlist.setTotalPrice(wishlist.getTotalPrice()+product.getPrice());
        productWishlistServices.addToWishlist(new ProductsWishlist(productId,user.getWishlistId()));
    }
    @Transactional
    public void deleteProductFromCart(Integer productId,Integer userId){
        User user = this.userServices.findUserById(userId);
        Product product = this.findProductById(productId);
        Cart cart= this.cartServices.findCartById(user.getCartId());
        cart.setProductNumber(cart.getProductNumber()-1);
        cart.setTotalPrice(cart.getTotalPrice()-product.getPrice());
        productCartServices.deleteProductFromCart(productId,user.getCartId());
    }
}