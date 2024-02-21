package com.example.demo.repository;

import com.example.demo.model.entity.ProductsCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductsCart,Integer> {
    void deleteByProductIdAndCartId(Integer productId,Integer cartId);
}
