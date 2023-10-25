package com.example.demo.services;

import com.example.demo.entity.WishlistEntity;
import com.example.demo.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistServices {
    @Autowired
    WishlistRepository wishlistRepository;

    public  WishlistEntity addWishlist(WishlistEntity wishlist){
        return wishlistRepository.save(wishlist);
    }
    public Optional<WishlistEntity> findWishlistById(Integer wishlistId){
        return wishlistRepository.findById(wishlistId);
    }
}
