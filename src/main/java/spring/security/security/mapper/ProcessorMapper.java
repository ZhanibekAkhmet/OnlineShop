package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.PhoneProcessorDto;
import spring.security.security.dto.ProcessorDto;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.model.Phone.PhoneProcessor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessorMapper {
        ProcessorDto toDto(Processor processor);

        Processor toModel(ProcessorDto processorDto);
        List<ProcessorDto> toDtoList(List<Processor> processorList);
        List<Processor> toModelList(List<ProcessorDto> processorDtoList);
}
