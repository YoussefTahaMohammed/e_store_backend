package com.example.demo.services.Impl;


import com.example.demo.entity.WishlistEntity;
import com.example.demo.repository.WishlistRepository;
import com.example.demo.services.WishlistServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistServicesImplement implements WishlistServices {
    private final WishlistRepository wishlistRepository;

    public  WishlistEntity addWishlist(WishlistEntity wishlist){
        return wishlistRepository.save(wishlist);
    }
    public WishlistEntity findWishlistById(Integer wishlistId){
        Optional<WishlistEntity> returnedWishlist = this.wishlistRepository.findById(wishlistId);
        return returnedWishlist.orElseGet(WishlistEntity::new);
    }
    public void deleteWishlistById(Integer id){
        wishlistRepository.deleteById(id);
    }
}
