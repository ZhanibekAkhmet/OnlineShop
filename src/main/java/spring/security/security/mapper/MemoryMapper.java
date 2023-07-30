package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.MemoryDto;
import spring.security.security.model.Memory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemoryMapper {

        MemoryDto toDto(Memory memory);

        Memory toModel(MemoryDto memoryDto);
        List<MemoryDto> toDtoList(List<Memory> memoryList);
        List<Memory> toModelList(List<MemoryDto> memoryDtoList);
}
