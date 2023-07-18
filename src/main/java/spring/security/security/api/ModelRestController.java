package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Laptop.Model;
import spring.security.security.service.ModelService;
//import spring.security.security.model.Notebooks.NotebookModel;
//import spring.security.security.service.NotebookModelService;


import java.util.List;

@RestController
@RequestMapping(value = "/model")
@RequiredArgsConstructor
public class ModelRestController {
    private final ModelService modelService;
    @GetMapping
    public List<Model> ModelList(){
        return modelService.getModels();
    }
    @GetMapping(value = "{id}")
    public Model   getModel(@PathVariable(name = "id") Long id){
        return modelService.getModel(id);
    }
    @PostMapping
    public Model addModel(@RequestBody Model model){
        return modelService.addModel(model);
    }
    @PutMapping
    public Model editModel(@RequestBody Model model){
        return modelService.editModel(model);
    }
    @DeleteMapping(value = "{id}")
    public void deleteNotebookModel(@PathVariable(name = "id")Long id){
        modelService.deleteModel(id);
    }
}
