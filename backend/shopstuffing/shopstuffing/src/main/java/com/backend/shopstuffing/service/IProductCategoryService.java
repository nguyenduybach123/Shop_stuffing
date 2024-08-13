package com.backend.shopstuffing.service;

import com.backend.shopstuffing.model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> findAllCategory();
}
