package com.jeffrey.POST_SERVICE.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.jeffrey.POST_SERVICE.models.User;

@FeignClient(name = "AUTHENTICATIONS")
public interface UserServiceClient {
    
    @GetMapping("/api/v1/users/{id}")
    ResponseEntity <User> findUserById(@PathVariable("id") Long id);
}