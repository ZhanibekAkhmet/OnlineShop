package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.CategoriesDto;
import spring.security.security.mapper.CategoriesMapper;

import spring.security.security.repository.CategoriesRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    private final CategoriesMapper categoriesMapper;

    public List<CategoriesDto> getCategories(){
        return categoriesMapper.toDtoList(categoriesRepository.findAll());
    }
    public CategoriesDto addCategories(CategoriesDto categories){
        return categoriesMapper.toDto(categoriesRepository.save(categoriesMapper.toModel(categories)));
    }
    public CategoriesDto getCategory(Long id){
        return categoriesMapper.toDto(categoriesRepository.findById(id).orElseThrow());
    }
    public CategoriesDto editCategories(CategoriesDto categories){
        return categoriesMapper.toDto(categoriesRepository.save(categoriesMapper.toModel(categories)));
    }
    public void deleteCategories(Long id){
        categoriesRepository.deleteById(id);
    }
}
