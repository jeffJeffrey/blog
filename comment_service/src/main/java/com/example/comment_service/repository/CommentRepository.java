
package com.example.comment_service.repository;
import com.example.comment_service.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);
}
