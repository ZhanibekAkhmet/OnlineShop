package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.CommentDto;
import spring.security.security.mapper.CommentMapper;
import spring.security.security.model.Comment;
import spring.security.security.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> getComments(Long id){
        return commentMapper.toDtoList(commentRepository.findByItemId(id));
    }
    public CommentDto addComment(CommentDto comment){
//        comment.setTime(LocalDateTime.now());
        return commentMapper.toDto(commentRepository.save(commentMapper.toModel(comment)));
    }
    public CommentDto getNComment(Long id){
        return commentMapper.toDto(commentRepository.findById(id).orElseThrow());
    }
    public CommentDto editComment(CommentDto comment){
        return commentMapper.toDto(commentRepository.save(commentMapper.toModel(comment)));
    }
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
