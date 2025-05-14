package com.jeffrey.SEACH_SERVICE.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeffrey.SEACH_SERVICE.dto.PostResponse;

import java.util.List;

@FeignClient(name = "POST-SERVICE")
public interface PostServiceClient {
    
    @GetMapping("/api/posts")
    List<PostResponse> getAllPosts();

    @GetMapping("/api/posts/{id}")
    PostResponse getPostById(@PathVariable Long id);

    @GetMapping("/api/posts/category/{category_id}")
    List<PostResponse> getPostsByCategory(@PathVariable("category_id") Long categoryId);
}