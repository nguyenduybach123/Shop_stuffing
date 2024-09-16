package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.CommentCreateRequest;
import com.backend.shopstuffing.dto.request.CommentUpdateRequest;
import com.backend.shopstuffing.dto.response.CommentResponse;
import com.backend.shopstuffing.exception.ApplicationException;
import com.backend.shopstuffing.exception.CommentErrorResponse;
import com.backend.shopstuffing.exception.ProductErrorResponse;
import com.backend.shopstuffing.exception.UserErrorResponse;
import com.backend.shopstuffing.mapper.CommentMapper;
import com.backend.shopstuffing.model.Comment;
import com.backend.shopstuffing.repository.ICommentRepository;
import com.backend.shopstuffing.repository.IProductRepository;
import com.backend.shopstuffing.repository.IUserRepository;
import com.backend.shopstuffing.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService  {

    private final ICommentRepository commentRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;

    @Override
    public CommentResponse createComment(CommentCreateRequest request) {
        if(!productRepository.existsById(request.getProductId())){
            throw new ApplicationException(ProductErrorResponse.PRODUCT_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        if(!userRepository.existsUserById(request.getUserId())){
            throw new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        Comment comment = CommentMapper.toComment(request);
        commentRepository.save(comment);

        return CommentMapper.toCommentResponse(comment);
    }

    @Override
    public void deleteComment(String id) {
        if(commentRepository.existsById(id)) {
            throw new ApplicationException(CommentErrorResponse.COMMENT_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        commentRepository.deleteById(id);
    }

    @Override
    public CommentResponse updateComment(CommentUpdateRequest request) {
        if(!productRepository.existsById(request.getProductId())){
            throw new ApplicationException(ProductErrorResponse.PRODUCT_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        if(!userRepository.existsUserById(request.getUserId())){
            throw new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        Comment comment = commentRepository.findById(request.getId()).orElseThrow(() -> new ApplicationException(CommentErrorResponse.COMMENT_NOT_EXISTED, HttpStatus.BAD_REQUEST));
        CommentMapper.updateComment(comment, request);

        return CommentMapper.toCommentResponse(comment);
    }
}
