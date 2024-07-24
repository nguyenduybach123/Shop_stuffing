package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.model.User;
import com.backend.shopstuffing.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }
}
