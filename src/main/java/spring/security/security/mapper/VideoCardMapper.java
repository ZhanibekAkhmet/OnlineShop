package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.ProcessorDto;
import spring.security.security.dto.VideoCardDto;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.model.Laptop.VideoCard;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VideoCardMapper {
        VideoCardDto toDto(VideoCard videoCard);

        VideoCard toModel(VideoCardDto videoCardDto);
        List<VideoCardDto> toDtoList(List<VideoCard> videoCardList);
        List<VideoCard> toModelList(List<VideoCardDto> videoCardDtoList);
}
