package com.moviestore.cjv.services;

import com.mongodb.MongoException;
import com.mongodb.MongoQueryException;
import com.moviestore.cjv.models.users.User;
import com.moviestore.cjv.models.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id) throws Exception
    {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new Exception("User with Id: " + id + " not found");
        }

        return user;
    }

    public User addUser(User user) {
        return userRepository.insert(user);
    }
}
