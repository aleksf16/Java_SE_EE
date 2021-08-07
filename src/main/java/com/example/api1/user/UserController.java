package com.example.api1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*@PostMapping("users")
    public void addUser(@RequestBody final List<User> Users) {
        userRepository.saveAll(Users);
    }*/

    @GetMapping("users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @GetMapping("users/{userId}")
    public User findUser(@PathVariable final String userId) {
        return userRepository.findById(userId).orElseGet(User::new);
    }

    @DeleteMapping("users/{userId}")
    public void deleteById(@PathVariable final String userId) { userRepository.deleteById(userId);    }

}
