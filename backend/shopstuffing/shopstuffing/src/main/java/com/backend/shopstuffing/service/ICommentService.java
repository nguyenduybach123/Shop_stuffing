package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.CommentCreateRequest;
import com.backend.shopstuffing.dto.request.CommentUpdateRequest;
import com.backend.shopstuffing.dto.response.CommentResponse;

public interface ICommentService {
    CommentResponse createComment(CommentCreateRequest request);
    void deleteComment(String id);
    CommentResponse updateComment(CommentUpdateRequest request);
}
