package com.backend.shopstuffing.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductVariant {
    private String subtitle;
    private String color;
    private List<String> images;
    private List<ProductSize> sizes;
}
