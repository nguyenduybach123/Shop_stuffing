package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.response.ProductDetailResponse;
import com.backend.shopstuffing.dto.response.ProductResponse;
import com.backend.shopstuffing.model.Comment;
import com.backend.shopstuffing.model.Product;

import java.util.List;

public class ProductMapper {

    public static ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .sold(product.getSold())
                .rating(product.getRating())
                .variants(product.getVariants())
                .build();
    }

    public static ProductDetailResponse toProductDetailResponse(Product product, List<Comment> comments) {
        return ProductDetailResponse.builder()
                .product(product)
                .comments(comments)
                .build();
    }
}
