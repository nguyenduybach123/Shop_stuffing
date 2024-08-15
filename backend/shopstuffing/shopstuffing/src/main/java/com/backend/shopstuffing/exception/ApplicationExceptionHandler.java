package com.backend.shopstuffing.exception;

import com.backend.shopstuffing.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = ApplicationException.class)
    ResponseEntity<ApiResponse> handlingApplicationException(ApplicationException ex) {
        ApiResponse response = ApiResponse.builder()
                .status(ex.getStatus().toString())
                .error(ex.getError())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }
}
