package com.backend.shopstuffing.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String avatar;
    private String gender;
    private String birth;
    private List<String> voucher;
    private String createdAt;
    private String updatedAt;
}
