package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public List<Categories> categoriesList(){
        return categoriesService.getCategories();
    }
    @GetMapping(value = "{id}")
    public Categories   getCategory(@PathVariable(name = "id") Long id){
        return categoriesService.getCategory(id);
    }
    @PostMapping
    public Categories addCategory(@RequestBody Categories categories){
        return categoriesService.addCategories(categories);
    }
    @PutMapping
    public Categories editCategory(@RequestBody Categories categories){
        return categoriesService.editCategories(categories);
    }
    @DeleteMapping(value = "{id}")
    public void deleteCategories(@PathVariable(name = "id")Long id){
        categoriesService.deleteCategories(id);
    }
}
