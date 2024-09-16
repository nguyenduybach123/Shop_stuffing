package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.dto.response.ProductDetailResponse;
import com.backend.shopstuffing.dto.response.ProductResponse;
import com.backend.shopstuffing.model.Discount;
import com.backend.shopstuffing.model.Product;
import com.backend.shopstuffing.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAllProduct() {

        return ApiResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK.toString())
                .data(productService.findAllProduct())
                .build();
    }

    @GetMapping("/featured")
    public ApiResponse<List<ProductResponse>> getFeaturedProducts() {

        return ApiResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK.toString())
                .data(productService.findFeaturedProducts())
                .build();
    }

    @GetMapping("/new")
    public ApiResponse<List<ProductResponse>> getNewProducts() {

        return ApiResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK.toString())
                .data(productService.findNewProducts())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDetailResponse> getProductDetail(@PathVariable String id) {

        return ApiResponse.<ProductDetailResponse>builder()
                .status(HttpStatus.OK.toString())
                .data(productService.productDetail(id))
                .build();
    }

}
