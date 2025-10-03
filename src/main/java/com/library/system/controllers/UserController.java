package com.library.system.controllers;

import com.library.system.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void RestCreateUsers() {
        users.addAll(List.of(
                new User(1, "Gleb", "Gleboostin", 15),
                new User(2, "Sasha", "Tsoy", 25)
        ));
    }

    @GetMapping
    Iterable<User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    Optional<User> getUserById(@PathVariable String id) {

        Integer idL = Integer.parseInt(id);

        for (User user : users) {

            if (user.getId().equals(idL)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
        void deleteUser(@PathVariable String id) {
            int targetId = Integer.parseInt(id);
            int newSize = 0;

        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).getId().equals(targetId)) {
                newSize++;
            }
        }

        User[] tempArray = new User[newSize];
            int index = 0;

        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).getId().equals(targetId)) {
                tempArray[index] = users.get(i);
                index++;
            }
        }

    users.clear();
    for (int i = 0; i < tempArray.length; i++) {
        users.add(tempArray[i]);
    }
}

    }

