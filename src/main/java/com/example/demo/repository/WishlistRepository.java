package com.example.demo.repository;

import com.example.demo.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishlistEntity,Integer> {
}
