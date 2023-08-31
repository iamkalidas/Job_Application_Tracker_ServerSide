package com.sensei.jobAppTrack.service;

import com.sensei.jobAppTrack.Repository.UserRepository;
import com.sensei.jobAppTrack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // ThreadLocal to store the currently authenticated user
//    private final ThreadLocal<User> authenticatedUserContext = new ThreadLocal<>();

    @Autowired
    private UserRepository repository;

    // Get the currently authenticated user
//    public User getAuthenticatedUser() {
//        return authenticatedUserContext.get();
//    }
//
//    // Set the currently authenticated user
//    public void setAuthenticatedUser(User user) {
//        authenticatedUserContext.set(user);
//    }
//
//    // Clear the currently authenticated user
//    public void clearAuthenticatedUser() {
//        authenticatedUserContext.remove();
//    }

    // Check if a user with the given username exists
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    // Check if a user with the given email exists
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    // Check if a user with the given username or email exists
    public boolean existsByUsernameOrEmail(String username, String email) {
        return repository.existsByUsernameOrEmail(username, email);
    }

    // Find a user by their username
    public User findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Find a user by their unique ID
    public User findUserById(int user_id) {
        return repository.findUserById(user_id);
    }

    // Get a user by their username
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Get a user by their email
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Register a new user
    public void registerUser(User user) {
        user.setPassword(user.getPassword()); // Make sure to handle password hashing before saving
        repository.save(user);
    }
}
