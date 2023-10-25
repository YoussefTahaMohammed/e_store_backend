package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping(path = "/addUser")
    public UserEntity addUser(@RequestBody UserEntity user){
        return this.userServices.addUser(user);
    }

    @GetMapping(path = "/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return this.userServices.getAllUsers();
    }
}
