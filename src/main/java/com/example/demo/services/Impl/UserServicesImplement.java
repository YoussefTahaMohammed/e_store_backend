package com.example.demo.services.Impl;

import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.Wishlist;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CartServices;
import com.example.demo.services.UserServices;
import com.example.demo.services.WishlistServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicesImplement implements UserServices {

    private final UserRepository userRepository;

    private final WishlistServices wishlistServices  ;

    private final CartServices cartServices  ;

    public User addUser(User user){
        Wishlist userWishlist =wishlistServices.addWishlist(new Wishlist(0,0.0));
        Cart userCart = cartServices.addCart(new Cart(0,0.0));
        User savedUser = userRepository.save(user);
        savedUser.setWishlistId(userWishlist.getWishlistId());
        savedUser.setCartId(userCart.getCartId());
        userRepository.save(savedUser);
        return savedUser;
    }

    public void deleteUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            wishlistServices.deleteWishlistById(user.getWishlistId());
            cartServices.deleteCartById(user.getCartId());
            userRepository.deleteById(id);
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User findUserById(Integer id){
        Optional<User> returnedUser = this.userRepository.findById(id);
        return returnedUser.orElseGet(User::new);
    }

}
