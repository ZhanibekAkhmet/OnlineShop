package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.NotebookDto;
import spring.security.security.model.Notebooks.Notebook;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotebookMapper {

        NotebookDto toDto(Notebook notebook);

        Notebook toModel(NotebookDto notebookDto);
        List<NotebookDto> toDtoList(List<Notebook> notebookList);
        List<Notebook> toModelList(List<NotebookDto> notebookDtoList);
}
