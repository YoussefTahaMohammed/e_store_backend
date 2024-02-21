package com.example.demo.services.Impl;


import com.example.demo.model.entity.Wishlist;
import com.example.demo.repository.WishlistRepository;
import com.example.demo.services.WishlistServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistServicesImplement implements WishlistServices {
    private final WishlistRepository wishlistRepository;

    public Wishlist addWishlist(Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }
    public Wishlist findWishlistById(Integer wishlistId){
        Optional<Wishlist> returnedWishlist = this.wishlistRepository.findById(wishlistId);
        return returnedWishlist.orElseGet(Wishlist::new);
    }
    public void deleteWishlistById(Integer id){
        wishlistRepository.deleteById(id);
    }
}
