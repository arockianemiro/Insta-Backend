package com.example.Instagram.Service;

import com.example.Instagram.Model.User;
import com.example.Instagram.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create / Save User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Read - Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read - Get User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update User
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setBio(userDetails.getBio());

        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}