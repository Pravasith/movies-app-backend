package com.moviestore.cjv.services;

import com.moviestore.cjv.models.users.User;
import com.moviestore.cjv.models.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.insert(user);
    }
}
