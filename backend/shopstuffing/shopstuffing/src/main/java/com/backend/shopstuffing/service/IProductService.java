package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.response.ProductDetailResponse;
import com.backend.shopstuffing.dto.response.ProductResponse;
import com.backend.shopstuffing.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponse> findAllProduct();
    List<ProductResponse> findFeaturedProducts();
    List<ProductResponse> findNewProducts();
    ProductDetailResponse productDetail(String id);
}
