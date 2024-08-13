package com.backend.shopstuffing.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "product")
public class Product {
    @Id
    private String id;

    private String categoryId;
    private String title;
    private int rating;
    private int sold;
    private String description;
    private List<ProductVariant> variants;
    private String createdAt;
    private String updatedAt;
}
