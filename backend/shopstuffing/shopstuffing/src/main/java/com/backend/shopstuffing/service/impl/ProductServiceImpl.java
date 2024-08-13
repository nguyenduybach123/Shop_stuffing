package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.model.Product;
import com.backend.shopstuffing.repository.IProductRepository;
import com.backend.shopstuffing.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepo;

    @Override
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }
}
