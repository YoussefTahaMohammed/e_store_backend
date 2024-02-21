package com.example.demo.repository;

import com.example.demo.model.entity.ProductsWishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsWishlistRepository extends JpaRepository<ProductsWishlist,Integer> {
}
