package com.backend.shopstuffing.dto.request;

import lombok.*;

@Getter
@Builder
public class UserUpdateRequest {
    private String password;
    private String firstName;
    private String lastName;
    private String birth;
}