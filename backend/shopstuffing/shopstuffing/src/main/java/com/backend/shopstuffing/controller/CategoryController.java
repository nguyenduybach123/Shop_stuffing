package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.model.ProductCategory;
import com.backend.shopstuffing.service.impl.ProductCategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final ProductCategoryServiceImpl categoryService;

    @GetMapping
    public ApiResponse<List<ProductCategory>> getAllCategory() {

        return ApiResponse.<List<ProductCategory>>builder()
                .status(HttpStatus.OK.toString())
                .data(categoryService.findAllCategory())
                .build();
    }

}
