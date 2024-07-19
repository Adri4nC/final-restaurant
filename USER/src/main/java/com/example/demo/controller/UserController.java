package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{iduser}")
    public User getUserById(@PathVariable Long iduser) {
        return userService.getUserById(iduser);
    }

    @PutMapping("/{iduser}")
    public User updateUser(@PathVariable Long iduser, @RequestBody User userDetails) {
        return userService.updateUser(iduser, userDetails);
    }

    @DeleteMapping("/{iduser}")
    public void deleteUser(@PathVariable Long iduser) {
        userService.deleteUser(iduser);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            // Devuelve un estado 200 OK con un mensaje
            return ResponseEntity.ok("Login successful");
        } else {
            // Devuelve un estado 401 Unauthorized con un mensaje
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
