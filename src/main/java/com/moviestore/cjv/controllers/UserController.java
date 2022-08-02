package com.moviestore.cjv.controllers;


import com.moviestore.cjv.models.users.User;
import com.moviestore.cjv.services.UserService;
import com.moviestore.cjv.utils.CustomizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    ResponseEntity<CustomizedResponse<List<User>>> getUsers() {
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: Fetched Users successfully" ,userService.getUsers()),
                HttpStatus.OK
        );
    }

    @PostMapping(
        value = "/users",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<CustomizedResponse<User>> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: User added successfully", user),
                HttpStatus.CREATED
        );
    }
}
