package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.MemoryDto;
import spring.security.security.model.Memory;
import spring.security.security.service.MemoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/memory")
@RequiredArgsConstructor
public class MemoryRestController {
    private final MemoryService memoryService;
    @GetMapping
    public List<MemoryDto> memoryList(){
        return memoryService.getMemories();
    }
    @GetMapping(value = "{id}")
    public MemoryDto   getMemory(@PathVariable(name = "id") Long id){
        return memoryService.getMemory(id);
    }
    @PostMapping
    public MemoryDto addMemory(@RequestBody MemoryDto memory){
        return memoryService.addMemory(memory);
    }
    @PutMapping
    public MemoryDto editMemory(@RequestBody MemoryDto memory){
        return memoryService.editMemory(memory);
    }
    @DeleteMapping(value = "{id}")
    public void deleteMemory(@PathVariable(name = "id")Long id){
        memoryService.deleteMemory(id);
    }
}
