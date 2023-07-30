package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.DiagonalDto;
import spring.security.security.model.Diagonal;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagonalMapper {

        DiagonalDto toDto(Diagonal diagonal);

        Diagonal toModel(DiagonalDto diagonalDto);
        List<DiagonalDto> toDtoList(List<Diagonal> diagonalList);
        List<Diagonal> toModelList(List<DiagonalDto> diagonalDtoList);
}
