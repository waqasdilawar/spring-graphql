package com.devgurupk.springgraphql.controller;

import com.devgurupk.springgraphql.model.User;
import com.devgurupk.springgraphql.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController
{
    private UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @QueryMapping
    public User findOne(@Argument Long id){
        return userRepository.findById(id);
    }
}
