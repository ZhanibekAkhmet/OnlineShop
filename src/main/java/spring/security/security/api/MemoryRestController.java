package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Memory;
import spring.security.security.service.MemoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/memory")
@RequiredArgsConstructor
public class MemoryRestController {
    private final MemoryService memoryService;
    @GetMapping
    public List<Memory> memoryList(){
        return memoryService.getMemories();
    }
    @GetMapping(value = "{id}")
    public Memory   getMemory(@PathVariable(name = "id") Long id){
        return memoryService.getMemory(id);
    }
    @PostMapping
    public Memory addMemory(@RequestBody Memory memory){
        return memoryService.addMemory(memory);
    }
    @PutMapping
    public Memory editMemory(@RequestBody Memory memory){
        return memoryService.editMemory(memory);
    }
    @DeleteMapping(value = "{id}")
    public void deleteMemory(@PathVariable(name = "id")Long id){
        memoryService.deleteMemory(id);
    }
}
