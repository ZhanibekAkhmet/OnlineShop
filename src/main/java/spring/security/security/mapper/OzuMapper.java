package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.OzuDto;
import spring.security.security.model.Ozu;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OzuMapper {

        OzuDto toDto(Ozu ozu);

        Ozu toModel(OzuDto ozuDto);
        List<OzuDto> toDtoList(List<Ozu> ozuList);
        List<Ozu> toModelList(List<OzuDto> ozuDtoList);
}
