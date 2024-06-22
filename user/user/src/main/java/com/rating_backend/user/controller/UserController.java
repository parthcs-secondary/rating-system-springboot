package com.rating_backend.user.controller;

import com.rating_backend.user.model.Users;
import com.rating_backend.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("create")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("create/bulk")
    public ResponseEntity<List<Users>> createBulkUsers(@RequestBody List<Users> users){
        return ResponseEntity.ok(userService.createBulkUsers(users));
    }

    @GetMapping("get/all")
    public ResponseEntity<List<Users>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //delete user

    //update a user


}
