package com.backend.shopstuffing.dto.request;


import lombok.*;

@Getter
@Builder
public class UserCreateRequest {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birth;
}
