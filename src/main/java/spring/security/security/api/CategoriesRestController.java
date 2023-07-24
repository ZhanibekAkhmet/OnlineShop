package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.CategoriesDto;
import spring.security.security.model.Categories;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.service.CategoriesService;
import spring.security.security.service.ProcessorService;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoriesRestController {
    private final CategoriesService categoriesService;
    @GetMapping
    public List<CategoriesDto> categoriesList(){
        return categoriesService.getCategories();
    }
    @GetMapping(value = "{id}")
    public CategoriesDto   getCategory(@PathVariable(name = "id") Long id){
        return categoriesService.getCategory(id);
    }
    @PostMapping
    public CategoriesDto addCategory(@RequestBody CategoriesDto categories){
        return categoriesService.addCategories(categories);
    }
    @PutMapping
    public CategoriesDto editCategory(@RequestBody CategoriesDto categories){
        return categoriesService.editCategories(categories);
    }
    @DeleteMapping(value = "{id}")
    public void deleteCategories(@PathVariable(name = "id")Long id){
        categoriesService.deleteCategories(id);
    }
}
