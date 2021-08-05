package com.example.demo.controllers;

import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticate")
    public User getUser(@RequestBody LoginForm lf) throws Exception {

        User user= this.userRepository.findByEmail(lf.email);
        if(user.getPassword().equals(lf.password)){
            return user;
        }else{
            throw new Exception("password invalid");
        }
    }
}

