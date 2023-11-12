package com.example.demo.services;


import com.example.demo.entity.UserEntity;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserServices {

    UserEntity addUser(UserEntity user);

    void deleteUserById(Integer id);

    List<UserEntity> getAllUsers();

    UserEntity findUserById(Integer id);

}
