package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.ItemDto;

import spring.security.security.model.Item;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

        ItemDto toDto(Item item);

        Item toModel(ItemDto itemDto);
        List<ItemDto> toDtoList(List<Item> itemList);
        List<Item> toModelList(List<ItemDto> itemDtoList);
}
