package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.CategoriesDto;
import spring.security.security.model.Categories;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

        CategoriesDto toDto(Categories categories);

        Categories toModel(CategoriesDto categoriesDto);
        List<CategoriesDto> toDtoList(List<Categories> categoriesList);
        List<Categories> toModelList(List<CategoriesDto> categoriesDtoList);
}
