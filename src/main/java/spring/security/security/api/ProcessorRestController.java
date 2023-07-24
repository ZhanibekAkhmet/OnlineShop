package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.ProcessorDto;
import spring.security.security.service.ProcessorService;

import java.util.List;

@RestController
@RequestMapping(value = "/processor")
@RequiredArgsConstructor
public class ProcessorRestController {
    private final ProcessorService processorService;
    @GetMapping
    public List<ProcessorDto> processList(){
        return processorService.getProcessors();
    }
    @GetMapping(value = "{id}")
    public ProcessorDto   getProcessor(@PathVariable(name = "id") Long id){
        return processorService.getProcessor(id);
    }
    @PostMapping
    public ProcessorDto addProcessor(@RequestBody ProcessorDto processor){
        return processorService.addProcessor(processor);
    }
    @PutMapping
    public ProcessorDto editProcessor(@RequestBody ProcessorDto processor){
        return processorService.editProcessor(processor);
    }
    @DeleteMapping(value = "{id}")
    public void deleteNotebook(@PathVariable(name = "id")Long id){
        processorService.deleteProcessor(id);
    }
}
