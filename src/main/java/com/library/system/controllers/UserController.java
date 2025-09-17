package com.library.system.controllers;

import com.library.system.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void RestCreateUsers() {
        users.addAll(List.of(
                new User(1L, "Gleb", "Gleboostin", 15),
                new User(2L, "Sasha", "Tsoy", 25)
        ));
    }

    @GetMapping
    Iterable<User> getUsers() {
        return users;
    }
}
