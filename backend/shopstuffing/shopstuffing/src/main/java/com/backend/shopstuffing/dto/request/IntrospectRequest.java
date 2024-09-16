package com.backend.shopstuffing.dto.request;

import lombok.*;

@Getter
@Builder
public class IntrospectRequest {
    private String token;
}
