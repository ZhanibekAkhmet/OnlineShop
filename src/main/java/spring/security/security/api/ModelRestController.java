package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Notebooks.NotebookModel;
import spring.security.security.service.NotebookModelService;


import java.util.List;

@RestController
@RequestMapping(value = "/model")
@RequiredArgsConstructor
public class ModelRestController {
    private final NotebookModelService notebookModelService;
    @GetMapping
    public List<NotebookModel> notebookModelList(){
        return notebookModelService.getNotebookModels();
    }
    @GetMapping(value = "{id}")
    public NotebookModel   getNotebookModel(@PathVariable(name = "id") Long id){
        return notebookModelService.getNotebookModel(id);
    }
    @PostMapping
    public NotebookModel addNotebookModel(@RequestBody NotebookModel notebookModel){
        return notebookModelService.addNotebookModel(notebookModel);
    }
    @PutMapping
    public NotebookModel editNotebookModel(@RequestBody NotebookModel notebookModel){
        return notebookModelService.editNotebookModel(notebookModel);
    }
    @DeleteMapping(value = "{id}")
    public void deleteNotebookModel(@PathVariable(name = "id")Long id){
        notebookModelService.deleteNotebookModel(id);
    }
}
