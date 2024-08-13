package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.model.ProductCategory;
import com.backend.shopstuffing.repository.IProductCategoryRepository;
import com.backend.shopstuffing.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private IProductCategoryRepository categoryRepo;

    @Override
    public List<ProductCategory> findAllCategory() {
        return categoryRepo.findAll();
    }
}
