package com.backend.shopstuffing.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product_category")
public class ProductCategory {
    @Id
    private String id;

    private String name;
    private String image;
}
