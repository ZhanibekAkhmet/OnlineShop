package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.ProcessorDto;
import spring.security.security.mapper.ProcessorMapper;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.repository.ProcessorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorService {
    private final ProcessorRepository processorRepository;
    private final ProcessorMapper processorMapper;

    public List<ProcessorDto> getProcessors(){
        return processorMapper.toDtoList(processorRepository.findAll());
    }
    public ProcessorDto addProcessor(ProcessorDto processor){
        return processorMapper.toDto(processorRepository.save(processorMapper.toModel(processor)));
    }
    public ProcessorDto getProcessor(Long id){
        return processorMapper.toDto(processorRepository.findById(id).orElseThrow());
    }
    public ProcessorDto editProcessor(ProcessorDto processor){
        return processorMapper.toDto(processorRepository.save(processorMapper.toModel(processor)));
    }
    public void deleteProcessor(Long id){
        processorRepository.deleteById(id);
    }
}
