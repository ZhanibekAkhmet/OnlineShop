package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.ItemDto;
import spring.security.security.dto.LaptopDto;
import spring.security.security.model.Item;
import spring.security.security.model.Laptop.Laptop;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LaptopMapper {

        LaptopDto toDto(Laptop laptop);

        Laptop toModel(LaptopDto laptopDto);
        List<LaptopDto> toDtoList(List<Laptop> laptopList);
        List<Laptop> toModelList(List<LaptopDto> laptopDtoList);
}
