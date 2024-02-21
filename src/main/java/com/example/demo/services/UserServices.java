package com.example.demo.services;


import com.example.demo.model.entity.User;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserServices {

    User addUser(User user);

    void deleteUserById(Integer id);

    List<User> getAllUsers();

    User findUserById(Integer id);

}
