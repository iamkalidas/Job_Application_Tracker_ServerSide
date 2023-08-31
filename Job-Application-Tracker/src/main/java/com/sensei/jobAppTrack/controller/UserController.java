package com.sensei.jobAppTrack.controller;

import com.sensei.jobAppTrack.apiResponse.ApiResponse;
import com.sensei.jobAppTrack.entity.User;
import com.sensei.jobAppTrack.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to check if a user with the provided username and email already exists
    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkUserExists(@RequestParam String username, @RequestParam String email) {
        boolean exists = userService.existsByUsernameOrEmail(username, email);
        return ResponseEntity.ok(exists);
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if the user already exists
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username is already taken"));
        }

        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email is already registered"));
        }

        // Create a new user
        userService.registerUser(user);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }

    // Endpoint to handle user login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User existingUser = userService.getUserByUsername(user.getUsername());

            if (existingUser != null) {
                if (existingUser.getPassword().equals(user.getPassword())) {
                    return ResponseEntity.ok(new ApiResponse(true, "Login successful"));
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(false, "Invalid password"));
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(false, "User not found"));
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(false, "User not found"));
        }
    }
}
