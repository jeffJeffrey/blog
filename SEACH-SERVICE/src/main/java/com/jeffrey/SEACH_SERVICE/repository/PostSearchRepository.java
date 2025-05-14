package com.jeffrey.SEACH_SERVICE.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jeffrey.SEACH_SERVICE.Models.PostDocument;

public interface PostSearchRepository extends ElasticsearchRepository<PostDocument, Long> {
    List<PostDocument> findByTitleContainingOrContentContaining(String title, String content);
    List<PostDocument> findByCategoryId(Long categoryId);
    List<PostDocument> findBySlug(String slug);
    void saveAll(List<PostDocument> documents);
}
