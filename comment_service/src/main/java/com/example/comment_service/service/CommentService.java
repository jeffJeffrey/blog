package com.example.comment_service.service;
import com.example.comment_service.model.Comment;
import com.example.comment_service.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {
    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Comment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comment create(Comment comment) {
        comment.setCreatedOn(new Date());
        comment.setLastUpdateOn(new Date());
        return repository.save(comment);
    }
    
    public List<Comment> findByPostId(Long post_id) {
        return repository.findByPostId(post_id);
    }
    public List<Comment> findByUserId(Long user_id) {
        return repository.findByUserId(user_id);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Comment save(Comment comment) {
        return repository.save(comment);
    }
}

