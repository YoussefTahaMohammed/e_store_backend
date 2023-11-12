package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {


    private final UserServices userServices;

    @PostMapping(path = "/addUser")
    public UserEntity addUser(@RequestBody UserEntity user){
        return this.userServices.addUser(user);
    }

    @GetMapping(path = "/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return this.userServices.getAllUsers();
    }
    @DeleteMapping(path = "deleteUserById")
    public void deleteUserById(@RequestParam Integer id){
        userServices.deleteUserById(id);

    }
}
