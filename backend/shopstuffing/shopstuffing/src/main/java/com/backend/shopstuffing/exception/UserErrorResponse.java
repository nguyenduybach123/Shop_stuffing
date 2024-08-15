package com.backend.shopstuffing.exception;

import lombok.Data;

@Data
public class UserErrorResponse extends ErrorResponse{
    public static final ErrorResponse USER_EXISTED = new UserErrorResponse("User existed");
    public static final ErrorResponse USER_NOT_EXISTED = new UserErrorResponse("User not existed");
    public UserErrorResponse(String message) {
        super(message);
    }
}
