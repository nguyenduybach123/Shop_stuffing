package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
