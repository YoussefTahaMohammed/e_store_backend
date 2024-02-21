package com.example.demo.services;


import com.example.demo.model.entity.Wishlist;

import org.springframework.stereotype.Service;


@Service
public interface WishlistServices {


    Wishlist addWishlist(Wishlist wishlist);

    Wishlist findWishlistById(Integer wishlistId);

    void deleteWishlistById(Integer id);
}
