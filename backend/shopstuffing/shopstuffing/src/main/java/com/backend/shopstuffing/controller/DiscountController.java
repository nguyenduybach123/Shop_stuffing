package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.model.Discount;
import com.backend.shopstuffing.service.impl.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountServiceImpl discountService;

    @GetMapping
    public ResponseEntity<List<Discount>> getAllDiscount() {
        return ResponseEntity.ok(discountService.findAllDiscount());
    }
}
