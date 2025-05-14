package com.example.comment_service.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Transient;

@EqualsAndHashCode(callSuper = true)
@Entity @AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Comment extends EntityBase {

    private String content;
    private Long postId;
    private Long userId;
   
    @Transient
    private Post post;
    
    @Transient
    private Users user;
}
