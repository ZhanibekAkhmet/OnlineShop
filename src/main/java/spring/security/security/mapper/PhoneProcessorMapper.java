package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.PhoneProcessorDto;
import spring.security.security.model.Phone.PhoneProcessor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneProcessorMapper {

        PhoneProcessorDto toDto(PhoneProcessor phoneProcessor);

        PhoneProcessor toModel(PhoneProcessorDto phoneProcessorDto);
        List<PhoneProcessorDto> toDtoList(List<PhoneProcessor> phoneProcessorList);
        List<PhoneProcessor> toModelList(List<PhoneProcessorDto> phoneProcessorDtoList);
}
