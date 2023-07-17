package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.PhoneDto;
import spring.security.security.model.Phone.Phone;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

        PhoneDto toDto(Phone phone);

        Phone toModel(PhoneDto phoneDto);
        List<PhoneDto> toDtoList(List<Phone> phoneList);
        List<Phone> toModelList(List<PhoneDto> phoneDtoList);
}
