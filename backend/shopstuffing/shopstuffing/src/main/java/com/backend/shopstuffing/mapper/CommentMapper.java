package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.request.CommentCreateRequest;
import com.backend.shopstuffing.dto.request.CommentUpdateRequest;
import com.backend.shopstuffing.dto.response.CommentResponse;
import com.backend.shopstuffing.model.Comment;

public class CommentMapper {

    public static Comment toComment(CommentCreateRequest request){
        return Comment.builder()
                .productId(request.getProductId())
                .userId(request.getUserId())
                .content(request.getContent())
                .createdAt(request.getCreatedAt())
                .build();
    }

    public static CommentResponse toCommentResponse(Comment comment){
        return CommentResponse.builder()
                .content(comment.getContent())
                .rating(comment.getRating())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static void updateComment(Comment comment, CommentUpdateRequest request) {
        comment.setContent(request.getContent());
    }
}
