package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.OzuDto;
import spring.security.security.mapper.OzuMapper;

import spring.security.security.repository.OzuRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OzuService {
    private final OzuRepository ozuRepository;
    private final OzuMapper ozuMapper;

    public List<OzuDto> getAllOzu(){
        return ozuMapper.toDtoList(ozuRepository.findAll());
    }
    public OzuDto addOzu(OzuDto ozu){
        return ozuMapper.toDto(ozuRepository.save(ozuMapper.toModel(ozu)));
    }
    public OzuDto getOzu(Long id){
        return ozuMapper.toDto(ozuRepository.findById(id).orElseThrow());
    }
    public OzuDto editOzu(OzuDto ozu){
        return ozuMapper.toDto(ozuRepository.save(ozuMapper.toModel(ozu)));
    }
    public void deleteOzu(Long id){
        ozuRepository.deleteById(id);
    }
}
