package com.moviestore.cjv.services;


import com.moviestore.cjv.models.media.Media;
import com.moviestore.cjv.models.users.UserModel;
import com.moviestore.cjv.models.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserModel> getUsers()
    {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUser(String id) throws Exception
    {
        Optional<UserModel> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new Exception("User with Id: " + id + " not found");
        }

        return user;
    }

    public UserModel addUser(UserModel user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.insert(user);
    }

    public UserModel authUser(String email, String password) throws Exception
    {

        Query query = new Query();
        query.addCriteria(
                Criteria
                        .where("email")
                        .is(email)

        );

        final UserModel databaseUser = mongoTemplate.findOne(query, UserModel.class);

        boolean isPasswordRight = bCryptPasswordEncoder.matches(password, databaseUser.getPassword());


        if(!isPasswordRight)
        {
            throw new Exception("Oops, password wasn't right!");
        }

        else
        {
            databaseUser.setPassword(null);
            return new UserModel(databaseUser.getFirstName(), databaseUser.getLastName(), databaseUser.getEmail());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return null;
    }
}
