package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.PhoneProcessorDto;
import spring.security.security.mapper.PhoneProcessorMapper;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.repository.PhoneProcessorRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneProcessorService {
    private final PhoneProcessorRepository processorRepository;
    private final PhoneProcessorMapper phoneProcessorMapper;

    public List<PhoneProcessorDto> getProcessors(){
        return phoneProcessorMapper.toDtoList(processorRepository.findAll());
    }
    public PhoneProcessorDto addProcessor(PhoneProcessorDto processor){
        return phoneProcessorMapper.toDto(processorRepository.save(phoneProcessorMapper.toModel(processor)));
    }
    public PhoneProcessorDto getProcessor(Long id){
        return phoneProcessorMapper.toDto(processorRepository.findById(id).orElseThrow());
    }
    public PhoneProcessorDto editProcessor(PhoneProcessorDto processor){
        return phoneProcessorMapper.toDto(processorRepository.save(phoneProcessorMapper.toModel(processor)));
    }
    public void deleteProcessor(Long id){
        processorRepository.deleteById(id);
    }
}
