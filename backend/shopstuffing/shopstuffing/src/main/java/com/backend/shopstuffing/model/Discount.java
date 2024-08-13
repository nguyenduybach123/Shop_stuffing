package com.backend.shopstuffing.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "discount")
public class Discount {
    @Id
    private String id;

    private String title;
    private String description;
    private String image;
    private String background;
    private Integer discountPercentage;
    private Date createdAt;
    private Date expiredAt;
}
