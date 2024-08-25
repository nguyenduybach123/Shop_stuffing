package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface IRoleRepository extends MongoRepository<Role, String> {
    void deleteByName(String name);
}
