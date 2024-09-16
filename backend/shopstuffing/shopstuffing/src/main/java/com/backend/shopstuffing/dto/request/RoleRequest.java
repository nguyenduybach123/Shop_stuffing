package com.backend.shopstuffing.dto.request;

import lombok.*;

import java.util.Set;

@Getter
@Builder
public class RoleRequest {
    private String name;
    private String description;
    private Set<String> permissions;
}
