package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductCategoryRepository extends MongoRepository<ProductCategory,String> {
}
