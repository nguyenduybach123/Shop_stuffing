package com.backend.shopstuffing.repository;

import com.backend.shopstuffing.dto.response.PermissionResponse;
import com.backend.shopstuffing.model.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPermissionRepository extends MongoRepository<Permission,String> {
    void deleteByName(String name);
    List<PermissionResponse> findAllByName(Iterable<String> names);
}
