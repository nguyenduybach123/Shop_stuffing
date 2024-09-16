package com.backend.shopstuffing.dto.request;

import lombok.*;

@Getter
@Builder
public class PermissionRequest {
  private String name;
  private String description;
}
