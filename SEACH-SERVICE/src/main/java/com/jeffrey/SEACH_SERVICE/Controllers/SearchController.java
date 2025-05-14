package com.jeffrey.SEACH_SERVICE.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeffrey.SEACH_SERVICE.Models.PostDocument;
import com.jeffrey.SEACH_SERVICE.repository.PostSearchRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    
    private final PostSearchRepository postSearchRepository;
    
    @GetMapping
    public List<PostDocument> searchPosts(@RequestParam String query) {
        return postSearchRepository.findByTitleContainingOrContentContaining(query, query);
    }
    
    @GetMapping("/category/{categoryId}")
    public List<PostDocument> searchByCategory(@PathVariable Long categoryId) {
        return postSearchRepository.findByCategoryId(categoryId);
    }
    
    @GetMapping("/slug/{slug}")
    public List<PostDocument> searchBySlug(@PathVariable String slug) {
        return postSearchRepository.findBySlug(slug);
    }
}
