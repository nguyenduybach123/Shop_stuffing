package com.backend.shopstuffing.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class CommentUpdateRequest {
    private String id;
    private String productId;
    private String userId;
    private String content;
}
