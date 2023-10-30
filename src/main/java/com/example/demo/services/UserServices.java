package com.example.demo.services;

import com.example.demo.entity.CartEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.WishlistEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WishlistServices wishlistServices  ;
    @Autowired
    CartServices cartServices  ;

    public UserEntity addUser(UserEntity user){
        WishlistEntity userWishlist =wishlistServices.addWishlist(new WishlistEntity(0,0.0));
        CartEntity userCart = cartServices.addCart(new CartEntity(0,0.0));
        UserEntity savedUser = userRepository.save(user);
        savedUser.setWishlistId(userWishlist.getWishlistId());
        savedUser.setCartId(userCart.getCartId());
        userRepository.save(savedUser);
        return savedUser;
    }

    public void deleteUserById(Integer id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            wishlistServices.deleteWishlistById(user.getWishlistId());
            cartServices.deleteCartById(user.getCartId());
            userRepository.deleteById(id);
        }
    }


    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

}
