package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.model.Discount;
import com.backend.shopstuffing.repository.IDiscountRepository;
import com.backend.shopstuffing.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements IDiscountService {

    @Autowired
    private IDiscountRepository discountRepo;

    @Override
    public List<Discount> findAllDiscount() {
        return discountRepo.findAll();
    }
}
