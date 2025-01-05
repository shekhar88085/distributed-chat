package com.chat.repository;

import com.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // Custom query to find a user by username
    User findByUsername(String username);

    // Check if a username already exists in the database
    boolean existsByUsername(String username);
}