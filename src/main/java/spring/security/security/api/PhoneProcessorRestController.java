package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.service.PhoneProcessorService;

import java.util.List;

@RestController
@RequestMapping(value = "/PhoneProcessor")
@RequiredArgsConstructor
public class PhoneProcessorRestController {
    private final PhoneProcessorService processorService;
    @GetMapping
    public List<PhoneProcessor> processList(){
        return processorService.getProcessors();
    }
    @GetMapping(value = "{id}")
    public PhoneProcessor   getProcessor(@PathVariable(name = "id") Long id){
        return processorService.getProcessor(id);
    }
    @PostMapping
    public PhoneProcessor addProcessor(@RequestBody PhoneProcessor processor){
        return processorService.addProcessor(processor);
    }
    @PutMapping
    public PhoneProcessor editProcessor(@RequestBody PhoneProcessor processor){
        return processorService.editProcessor(processor);
    }
    @DeleteMapping(value = "{id}")
    public void deleteProcessor(@PathVariable(name = "id")Long id){
        processorService.deleteProcessor(id);
    }
}
