package com.jeffrey.SEACH_SERVICE.services;

import java.util.stream.Collectors;

import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jeffrey.SEACH_SERVICE.Models.PostDocument;
import com.jeffrey.SEACH_SERVICE.dto.PostResponse;
import com.jeffrey.SEACH_SERVICE.repository.PostSearchRepository;
import com.jeffrey.SEACH_SERVICE.repository.PostServiceClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostSyncService {
    
    private final PostServiceClient postServiceClient;
    private final PostSearchRepository postSearchRepository;
    
    @Scheduled(fixedRate = 60000) // Sync every minute
    public void syncAllPosts() {
        List<PostResponse> posts = postServiceClient.getAllPosts();
        List<PostDocument> documents = posts.stream()
                .map(this::convertToDocument)
                .collect(Collectors.toList());
        
        postSearchRepository.saveAll(documents);
        System.out.println("Synchronized " + documents.size() + " posts");
    }
    
    private PostDocument convertToDocument(PostResponse response) {
        PostDocument document = new PostDocument();
        document.setId(response.getId());
        document.setTitle(response.getTitle());
        document.setContent(response.getContent());
        document.setSlug(response.getSlug());
        document.setCategory_id(response.getCategoryId());;
        return document;
    }
}