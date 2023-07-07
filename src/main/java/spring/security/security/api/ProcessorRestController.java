package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Notebooks.Processor;
import spring.security.security.service.ProcessorService;

import java.util.List;

@RestController
@RequestMapping(value = "/processor")
@RequiredArgsConstructor
public class ProcessorRestController {
    private final ProcessorService processorService;
    @GetMapping
    public List<Processor> processList(){
        return processorService.getProcessors();
    }
    @GetMapping(value = "{id}")
    public Processor   getProcessor(@PathVariable(name = "id") Long id){
        return processorService.getProcessor(id);
    }
    @PostMapping
    public Processor addProcessor(@RequestBody Processor processor){
        return processorService.addProcessor(processor);
    }
    @PutMapping
    public Processor editProcessor(@RequestBody Processor processor){
        return processorService.editProcessor(processor);
    }
    @DeleteMapping(value = "{id}")
    public void deleteNotebook(@PathVariable(name = "id")Long id){
        processorService.deleteProcessor(id);
    }
}
