package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.CommentDto;
import spring.security.security.service.CommentService;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
public class CommentRestController {
    private final CommentService commentService;
    @GetMapping(value = "/itemComment/{id}")
    public List<CommentDto> comentModelList(@PathVariable(name = "id") Long id){
        return commentService.getComments(id);
    }
    @GetMapping(value = "{id}")
    public CommentDto   getComment(@PathVariable(name = "id") Long id){
        return commentService.getNComment(id);
    }
    @PostMapping
    public CommentDto addComment(@RequestBody CommentDto comment){
        comment.setTime(LocalDateTime.now());
        return commentService.addComment(comment);
    }
    @PutMapping
    public CommentDto editComment(@RequestBody CommentDto comment){
        return commentService.editComment(comment);
    }
    @DeleteMapping(value = "{id}")
    public void deleteComment(@PathVariable(name = "id")Long id){
        commentService.deleteComment(id);
    }
}
