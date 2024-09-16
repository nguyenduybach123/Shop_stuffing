package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.response.ProductDetailResponse;
import com.backend.shopstuffing.dto.response.ProductResponse;
import com.backend.shopstuffing.exception.ApplicationException;
import com.backend.shopstuffing.exception.ProductErrorResponse;
import com.backend.shopstuffing.mapper.ProductMapper;
import com.backend.shopstuffing.model.Comment;
import com.backend.shopstuffing.model.Product;
import com.backend.shopstuffing.repository.ICommentRepository;
import com.backend.shopstuffing.repository.IProductRepository;
import com.backend.shopstuffing.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final int SOLD_LIMIT = 25;
    private final int RATING_LIMIT = 3;
    private final int MONTH_EXPIRED = -2;
    private final IProductRepository productRepository;
    private final ICommentRepository commentRepository;

    @Override
    public List<ProductResponse> findAllProduct() {
        return productRepository.findAll().stream().map(ProductMapper::toProductResponse).toList();
    }

    @Override
    public List<ProductResponse> findFeaturedProducts() {
        return productRepository.findBySoldGreaterThanEqualAndRatingGreaterThanEqual(SOLD_LIMIT, RATING_LIMIT).stream().map(ProductMapper::toProductResponse).toList();
    }

    @Override
    public List<ProductResponse> findNewProducts() {
        Calendar calendar = Calendar.getInstance();
        Date endDay = new Date();

        calendar.add(Calendar.MONTH, MONTH_EXPIRED);
        Date startDay = calendar.getTime();

        return productRepository.findByCreatedAtBetween(startDay, endDay).stream().map(ProductMapper::toProductResponse).toList();
    }

    @Override
    public ProductDetailResponse productDetail(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ProductErrorResponse.PRODUCT_NOT_EXISTED, HttpStatus.BAD_REQUEST));
        List<Comment> comments = commentRepository.findByProductId(product.getId());
        return ProductMapper.toProductDetailResponse(product, comments);
    }

}
