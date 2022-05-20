package com.devgurupk.springgraphql.controller;

import com.devgurupk.springgraphql.model.User;
import com.devgurupk.springgraphql.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
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
    public List<User> allUsers()
    {
        return userRepository.findAll();
    }

    @MutationMapping
    public User addUser(@Argument User user)
    {
        return userRepository.addUser(user);
    }

    @QueryMapping
    public User findOne(@Argument Long id)
    {
        return userRepository.findById(id);
    }

    @SubscriptionMapping
    public Flux<User> getRandomUser()
    {
        return Flux.interval(Duration.ofSeconds(1)).map(i -> {
            long leftLimit = 1L;
            long rightLimit =  userRepository.findAll().size();
            long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            return userRepository.findById(generatedLong);
        });
    }
}
