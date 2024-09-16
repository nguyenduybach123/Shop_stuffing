package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.model.Discount;
import com.backend.shopstuffing.model.ProductCategory;
import com.backend.shopstuffing.service.impl.DiscountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discount")
@AllArgsConstructor
public class DiscountController {
    private final DiscountServiceImpl discountService;

    @GetMapping
    public ApiResponse<List<Discount>> getAllDiscount() {

        return ApiResponse.<List<Discount>>builder()
                .status(HttpStatus.OK.toString())
                .data(discountService.findAllDiscount())
                .build();
    }

    @GetMapping("/not-expired")
    public ApiResponse<List<Discount>> getAllDiscountNotExpired() {

        return ApiResponse.<List<Discount>>builder()
                .status(HttpStatus.OK.toString())
                .data(discountService.findNotExpiredDiscounts())
                .build();
    }

}
