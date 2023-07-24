package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.PhoneProcessorDto;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.service.PhoneProcessorService;

import java.util.List;

@RestController
@RequestMapping(value = "/PhoneProcessor")
@RequiredArgsConstructor
public class PhoneProcessorRestController {
    private final PhoneProcessorService processorService;
    @GetMapping
    public List<PhoneProcessorDto> processList(){
        return processorService.getProcessors();
    }
    @GetMapping(value = "{id}")
    public PhoneProcessorDto   getProcessor(@PathVariable(name = "id") Long id){
        return processorService.getProcessor(id);
    }
    @PostMapping
    public PhoneProcessorDto addProcessor(@RequestBody PhoneProcessorDto processor){
        return processorService.addProcessor(processor);
    }
    @PutMapping
    public PhoneProcessorDto editProcessor(@RequestBody PhoneProcessorDto processor){
        return processorService.editProcessor(processor);
    }
    @DeleteMapping(value = "{id}")
    public void deleteProcessor(@PathVariable(name = "id")Long id){
        processorService.deleteProcessor(id);
    }
}
