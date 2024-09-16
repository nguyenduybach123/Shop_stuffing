package com.backend.shopstuffing.exception;

public class ProductErrorResponse extends ErrorResponse{
    public static final ErrorResponse PRODUCT_NOT_EXISTED = new UserErrorResponse("Product not existed");
}
