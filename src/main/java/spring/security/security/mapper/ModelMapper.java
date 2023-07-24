package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.MemoryDto;
import spring.security.security.dto.ModelDto;
import spring.security.security.model.Laptop.Model;
import spring.security.security.model.Memory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

        ModelDto toDto(Model model);

        Model toModel(ModelDto modelDto);
        List<ModelDto> toDtoList(List<Model> modelList);
        List<Model> toModelList(List<ModelDto> modelDtoList);
}
