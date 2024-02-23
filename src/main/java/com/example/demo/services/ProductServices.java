package com.example.demo.services;


import com.example.demo.model.dto.ProductReqDTO;
import com.example.demo.model.dto.ProductResDTO;
import com.example.demo.model.dto.ProductUpdateReqDTO;
import com.example.demo.model.entity.Product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public interface ProductServices {

    ProductResDTO addProduct(ProductReqDTO product);

    ProductResDTO updateProduct(ProductUpdateReqDTO productReqDTO);

    public void deleteProduct(Integer id);

    List<ProductResDTO> getAllProducts();

    Product findProductById(Integer id);

    void addProductToCart(Integer productId, Integer userId);

    void addProductToWishlist(Integer productId, Integer userId);

    @Transactional
    void deleteProductFromCart(Integer productId, Integer userId);
}