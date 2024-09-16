package com.backend.shopstuffing.dto.request;

import lombok.*;

@Getter
@Builder
public class RefreshRequest {
    private String token;
}
