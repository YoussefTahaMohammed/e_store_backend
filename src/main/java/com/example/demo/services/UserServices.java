package com.example.demo.services;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.WishlistEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository ;

    public UserEntity addUser(UserEntity user){
        wishlistRepository.save(new WishlistEntity(0,0.0));
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

}
