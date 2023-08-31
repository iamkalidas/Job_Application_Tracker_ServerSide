package com.sensei.jobAppTrack.Repository;

import com.sensei.jobAppTrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Find a user by their username
    public User findByUsername(String username);

    // Find a user by their email address
    public User findByEmail(String email);

    // Find a user by their unique ID
    public User findUserById(int user_id);

    // Check if a user with the given username or email exists
    public boolean existsByUsernameOrEmail(String username, String email);

    // Check if a user with the given email exists
    public boolean existsByEmail(String email);

    // Check if a user with the given username exists
    public boolean existsByUsername(String username);
}
