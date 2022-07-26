package com.moviestore.cjv.controllers;


import com.moviestore.cjv.models.users.UserModel;
import com.moviestore.cjv.services.UserService;
import com.moviestore.cjv.utils.CustomizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    ResponseEntity<CustomizedResponse<List<UserModel>>> getUsers()
    {
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: Fetched Users successfully" ,userService.getUsers()),
                HttpStatus.OK
        );
    }

    @GetMapping("/users/{id}")
    ResponseEntity<CustomizedResponse<Optional<UserModel>>> getUser(@PathVariable String id)
    {
        CustomizedResponse<Optional<UserModel>> customizedResponse = null;

        try
        {
            customizedResponse = new CustomizedResponse<>("200: Fetched User successfully", userService.getUser(id));
        }
        catch (Exception e)
        {
            customizedResponse = new CustomizedResponse<>("400: " + e.getMessage(), null);
            return new ResponseEntity<>(
                    customizedResponse,
                    HttpStatus.BAD_GATEWAY
            );
        }

        return new ResponseEntity<>(
                customizedResponse,
                HttpStatus.OK
        );
    }

    @PostMapping(
        value = "/users",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<CustomizedResponse<UserModel>> addUser(@RequestBody UserModel user)
    {
        userService.addUser(user);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: User added successfully", user),
                HttpStatus.CREATED
        );
    }

    @PostMapping(
            value = "/users/auth",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<CustomizedResponse<UserModel>> authUser (@RequestBody UserModel user) {

        CustomizedResponse<UserModel> customizedResponse = null;

        try
        {
            customizedResponse = new CustomizedResponse<>(
                    "200: Fetched User successfully",
                    userService.authUser(user.getEmail(), user.getPassword()));
        }
        catch (Exception e)
        {
            customizedResponse = new CustomizedResponse<>(e.getMessage(), null);
            return new ResponseEntity<>(
                    customizedResponse,
                    HttpStatus.UNAUTHORIZED
            );
        }

        return new ResponseEntity<>(
                customizedResponse,
                HttpStatus.OK
        );
    }
}
