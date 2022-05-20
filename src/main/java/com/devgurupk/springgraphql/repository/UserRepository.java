package com.devgurupk.springgraphql.repository;

import com.devgurupk.springgraphql.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository
{
    private List<User> users = new ArrayList<>();

    public List<User> findAll()
    {
        return users;
    }

    public User findById(Long id)
    {
        return users.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostConstruct
    private void init()
    {
        users.add(new User(1L, "Waqas", "Dilawar"));
        users.add(new User(2L, "Mubeen", "Aslam"));
        users.add(new User(3L, "Mohsin", "Rana"));
    }
}
