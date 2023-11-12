package com.example.demo.services;


import com.example.demo.entity.WishlistEntity;

import org.springframework.stereotype.Service;


@Service
public interface WishlistServices {


    WishlistEntity addWishlist(WishlistEntity wishlist);

    WishlistEntity findWishlistById(Integer wishlistId);

    void deleteWishlistById(Integer id);
}
