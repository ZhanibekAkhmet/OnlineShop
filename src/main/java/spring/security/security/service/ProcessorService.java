package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Notebooks.Processor;
import spring.security.security.repository.ProcessorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorService {
    private final ProcessorRepository processorRepository;

    public List<Processor> getProcessors(){
        return processorRepository.findAll();
    }
    public Processor addProcessor(Processor processor){
        return processorRepository.save(processor);
    }
    public Processor getProcessor(Long id){
        return processorRepository.findById(id).orElseThrow();
    }
    public Processor editProcessor(Processor processor){
        return processorRepository.save(processor);
    }
    public void deleteProcessor(Long id){
        processorRepository.deleteById(id);
    }
}
