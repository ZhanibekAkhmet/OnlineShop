package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Comment;
import spring.security.security.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long id){
        return commentRepository.findByItemId(id);
    }
    public Comment addComment(Comment comment){
//        comment.setTime(LocalDateTime.now());
        return commentRepository.save(comment);
    }
    public Comment getNComment(Long id){
        return commentRepository.findById(id).orElseThrow();
    }
    public Comment editComment(Comment comment){
        return commentRepository.save(comment);
    }
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
