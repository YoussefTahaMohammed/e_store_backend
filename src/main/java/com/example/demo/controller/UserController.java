package com.example.demo.controller;

import com.example.demo.model.entity.User;
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
    public User addUser(@RequestBody User user){
        return this.userServices.addUser(user);
    }

    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUsers(){
        return this.userServices.getAllUsers();
    }
    @DeleteMapping(path = "deleteUserById")
    public void deleteUserById(@RequestParam Integer id){
        userServices.deleteUserById(id);

    }
}
