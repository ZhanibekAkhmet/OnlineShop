package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.NotebookDto;
import spring.security.security.service.NotebookService;
import java.util.List;

@RestController
@RequestMapping(value = "/notebook")
@RequiredArgsConstructor
public class NotebookRestController {
    private final NotebookService notebookService;
    @GetMapping
    public List<NotebookDto> notebookList(){
        return notebookService.getNotebooks();
    }
    @GetMapping(value = "{id}")
    public NotebookDto   getNotebook(@PathVariable(name = "id") Long id){
        return notebookService.getNotebook(id);
    }
    @PostMapping
    public NotebookDto addNotebook(@RequestBody NotebookDto notebook){
        return notebookService.addNotebook(notebook);
    }
    @PutMapping
    public NotebookDto editNotebook(@RequestBody NotebookDto notebook){
        return notebookService.editNotebook(notebook);
    }
    @DeleteMapping(value = "{id}")
    public void deleteNotebook(@PathVariable(name = "id")Long id){
        notebookService.deleteNotebook(id);
    }
}