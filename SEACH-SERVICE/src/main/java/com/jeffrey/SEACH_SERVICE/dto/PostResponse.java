package com.jeffrey.SEACH_SERVICE.dto;

import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String slug;
    private Long categoryId;
}