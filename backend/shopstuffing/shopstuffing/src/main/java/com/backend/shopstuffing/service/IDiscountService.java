package com.backend.shopstuffing.service;

import com.backend.shopstuffing.model.Discount;

import java.util.List;

public interface IDiscountService {
    List<Discount> findAllDiscount();
    List<Discount> findNotExpiredDiscounts();
}
