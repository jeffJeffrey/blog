package com.example.comment_service.repository;
import com.example.comment_service.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentications")
public interface UserServiceClient {
    @GetMapping("/api/v1/users/{id}")
    Users findUsersById(@PathVariable("id") Long id);
}