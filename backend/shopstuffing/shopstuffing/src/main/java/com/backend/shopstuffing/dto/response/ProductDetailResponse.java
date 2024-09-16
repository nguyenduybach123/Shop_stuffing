package com.backend.shopstuffing.dto.response;

import com.backend.shopstuffing.model.Comment;
import com.backend.shopstuffing.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailResponse {
    private Product product;
    private List<Comment> comments;
}
