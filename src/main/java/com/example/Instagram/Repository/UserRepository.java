package com.example.Instagram.Repository;

import com.example.Instagram.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA automatically gives you built-in CRUD methods:
    // - save(User user)
    // - findById(Long id)
    // - findAll()
    // - deleteById(Long id)

    // Optional custom query method (useful for login/lookup):
    User findByUsername(String username);
}