package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {
    boolean existsUserByUsername(String username);
    Optional<User> findByUsername(String username);
}
