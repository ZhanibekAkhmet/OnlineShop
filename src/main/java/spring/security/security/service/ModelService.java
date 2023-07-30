package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.ModelDto;
import spring.security.security.mapper.ModelMapper;
import spring.security.security.repository.ModelRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public List<ModelDto> getModels(){
        return modelMapper.toDtoList(modelRepository.findAll());
    }
    public ModelDto addModel(ModelDto model){
        return modelMapper.toDto(modelRepository.save(modelMapper.toModel(model)));
    }
    public ModelDto getModel(Long id){
        return modelMapper.toDto(modelRepository.findById(id).orElseThrow());
    }
    public ModelDto editModel(ModelDto model){
        return modelMapper.toDto(modelRepository.save(modelMapper.toModel(model)));
    }
    public void deleteModel(Long id){
        modelRepository.deleteById(id);
    }
}
