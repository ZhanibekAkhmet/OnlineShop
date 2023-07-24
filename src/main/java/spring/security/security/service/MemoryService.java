package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.MemoryDto;
import spring.security.security.mapper.MemoryMapper;

import spring.security.security.repository.MemoryRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryMapper memoryMapper;

    public List<MemoryDto> getMemories(){
        return memoryMapper.toDtoList(memoryRepository.findAll());
    }
    public MemoryDto addMemory(MemoryDto memory){
        return memoryMapper.toDto(memoryRepository.save(memoryMapper.toModel(memory)));
    }
    public MemoryDto getMemory(Long id){
        return memoryMapper.toDto(memoryRepository.findById(id).orElseThrow());
    }
    public MemoryDto editMemory(MemoryDto memory){
        return memoryMapper.toDto(memoryRepository.save(memoryMapper.toModel(memory)));
    }
    public void deleteMemory(Long id){
        memoryRepository.deleteById(id);
    }
}
