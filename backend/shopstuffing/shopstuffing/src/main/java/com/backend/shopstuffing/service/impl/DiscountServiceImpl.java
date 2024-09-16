package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.model.Discount;
import com.backend.shopstuffing.repository.IDiscountRepository;
import com.backend.shopstuffing.service.IDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements IDiscountService {
    private final IDiscountRepository discountRepository;

    @Override
    public List<Discount> findAllDiscount() {
        return discountRepository.findAll();
    }

    @Override
    public List<Discount> findNotExpiredDiscounts() {
        return discountRepository.findByExpiredAtLessThan(new Date());
    }
}
