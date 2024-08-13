package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCreatedAtBetween(Date startDay, Date endDay);
    List<Product> findBySoldGreaterThanEqualAndRatingGreaterThanEqual(int soldLimit, int ratingLimit);
}
