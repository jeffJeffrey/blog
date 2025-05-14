// Exemple : Post.java
package com.example.comment_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Long id;
    private String title;
    private String content;
    private String slug;
}
