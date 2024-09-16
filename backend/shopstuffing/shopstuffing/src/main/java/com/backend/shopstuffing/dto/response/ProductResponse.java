package com.backend.shopstuffing.dto.response;

import com.backend.shopstuffing.model.Comment;
import com.backend.shopstuffing.model.Product;
import com.backend.shopstuffing.model.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String title;
    private int rating;
    private int sold;
    private String description;
    private List<ProductVariant> variants;
}
