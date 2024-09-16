package com.backend.shopstuffing.exception;

public class CommentErrorResponse extends ErrorResponse{
    public static final ErrorResponse COMMENT_NOT_EXISTED = new UserErrorResponse("Comment not existed");
}
