package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Memory;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.repository.MemoryRepository;
import spring.security.security.repository.PhoneProcessorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;

    public List<Memory> getMemories(){
        return memoryRepository.findAll();
    }
    public Memory addMemory(Memory memory){
        return memoryRepository.save(memory);
    }
    public Memory getMemory(Long id){
        return memoryRepository.findById(id).orElseThrow();
    }
    public Memory editMemory(Memory memory){
        return memoryRepository.save(memory);
    }
    public void deleteMemory(Long id){
        memoryRepository.deleteById(id);
    }
}
