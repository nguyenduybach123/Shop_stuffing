package com.backend.shopstuffing.service;

import com.backend.shopstuffing.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
}
