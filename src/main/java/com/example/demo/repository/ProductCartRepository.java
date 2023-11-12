package com.example.demo.repository;

import com.example.demo.entity.ProductsCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductsCartEntity,Integer> {
    void deleteByProductIdAndCartId(Integer productId,Integer cartId);
}
