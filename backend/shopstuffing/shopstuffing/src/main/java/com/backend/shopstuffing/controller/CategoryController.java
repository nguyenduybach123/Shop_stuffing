package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.model.ProductCategory;
import com.backend.shopstuffing.service.impl.ProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllCategory() {
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

}
