package com.backend.shopstuffing.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {
    private ErrorResponse error;
    private HttpStatus status;

    public ApplicationException(ErrorResponse error, HttpStatus status) {
        super(error.getMessage());
        this.error = error;
        this.status = status;
    }
}
