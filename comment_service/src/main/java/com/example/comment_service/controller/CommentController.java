package com.example.comment_service.controller;
import com.example.comment_service.model.Comment;
import com.example.comment_service.service.CommentService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(comment));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Comment updated, 
                                    @RequestHeader("X-User-Id") Long userId) {
        Comment existing = service.findById(id);
        if (!existing.getUserId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }

        existing.setContent(updated.getContent());
        return ResponseEntity.ok(service.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id,
                                    @RequestHeader("X-User-Id") Long userId) {
        Comment existing = service.findById(id);
        if (!existing.getUserId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getByPostId(@PathVariable Long postId) {
        List<Comment> comments = service.findByPostId(postId);
        return ResponseEntity.ok(comments);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getByUserId(@PathVariable Long userId) {
        List<Comment> comments = service.findByUserId(userId);
        return ResponseEntity.ok(comments);
    }
}
