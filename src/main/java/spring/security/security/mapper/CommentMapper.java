package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.CommentDto;
import spring.security.security.model.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

        CommentDto toDto(Comment comment);

        Comment toModel(CommentDto commentDto);
        List<CommentDto> toDtoList(List<Comment> commentList);
        List<Comment> toModelList(List<CommentDto> commentDtoList);
}
