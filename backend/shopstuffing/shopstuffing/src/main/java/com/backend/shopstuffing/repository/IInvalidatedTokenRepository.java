package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.InvalidatedToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IInvalidatedTokenRepository extends MongoRepository<InvalidatedToken, String> {
}
