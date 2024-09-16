package com.backend.shopstuffing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;

    private String productId;
    private String userId;
    private Object user;
    private String content;
    private Integer rating;
    private Date createdAt;
}
