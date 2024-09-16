package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ICommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByProductId(String productId);
}
