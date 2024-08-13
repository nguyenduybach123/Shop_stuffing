package com.backend.shopstuffing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String firstname;
    private String lastname;
    private String avatar;
    private String gender;
    private String birth;
    private Optional<List<String>> vouchers;
    private Set<String> roles;
    private Date createdAt;
    private Date updateAt;
}
