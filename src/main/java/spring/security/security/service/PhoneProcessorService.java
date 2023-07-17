package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.repository.PhoneProcessorRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneProcessorService {
    private final PhoneProcessorRepository processorRepository;

    public List<PhoneProcessor> getProcessors(){
        return processorRepository.findAll();
    }
    public PhoneProcessor addProcessor(PhoneProcessor processor){
        return processorRepository.save(processor);
    }
    public PhoneProcessor getProcessor(Long id){
        return processorRepository.findById(id).orElseThrow();
    }
    public PhoneProcessor editProcessor(PhoneProcessor processor){
        return processorRepository.save(processor);
    }
    public void deleteProcessor(Long id){
        processorRepository.deleteById(id);
    }
}
