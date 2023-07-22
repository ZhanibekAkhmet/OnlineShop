package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Categories;
import spring.security.security.model.Comment;
import spring.security.security.repository.CategoriesRepository;
import spring.security.security.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }
    public Categories addCategories(Categories categories){
        return categoriesRepository.save(categories);
    }
    public Categories getCategory(Long id){
        return categoriesRepository.findById(id).orElseThrow();
    }
    public Categories editCategories(Categories categories){
        return categoriesRepository.save(categories);
    }
    public void deleteCategories(Long id){
        categoriesRepository.deleteById(id);
    }
}
