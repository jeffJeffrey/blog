package com.jeffrey.SEACH_SERVICE.Models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import org.springframework.data.elasticsearch.annotations.FieldType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Document(indexName = "posts")
public class PostDocument {
    @Id
    private Long id;
    
    @Field(type = FieldType.Text, analyzer = "english")
    private String title;
    
    @Field(type = FieldType.Text, analyzer = "english")
    private String content;
    
    @Field(type = FieldType.Keyword)
    private String slug;
    
    @Field(type = FieldType.Long)
    private Long category_id;
}
