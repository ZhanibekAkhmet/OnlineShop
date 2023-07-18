package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Laptop.Model;
import spring.security.security.repository.ModelRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public List<Model> getModels(){
        return modelRepository.findAll();
    }
    public Model addModel(Model model){
        return modelRepository.save(model);
    }
    public Model getModel(Long id){
        return modelRepository.findById(id).orElseThrow();
    }
    public Model editModel(Model model){
        return modelRepository.save(model);
    }
    public void deleteModel(Long id){
        modelRepository.deleteById(id);
    }
}
