package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IDiscountRepository extends MongoRepository<Discount, String> {
    List<Discount> findByExpiredAtLessThan(Date today);
}
