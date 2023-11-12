package com.example.demo.repository;

import com.example.demo.entity.ProductsWishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsWishlistRepository extends JpaRepository<ProductsWishlistEntity,Integer> {
}
