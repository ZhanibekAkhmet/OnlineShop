package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.DiagonalDto;
import spring.security.security.mapper.DiagonalMapper;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Memory;
import spring.security.security.repository.DiagonalRepository;
import spring.security.security.repository.MemoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagonalService {
    private final DiagonalRepository diagonalRepository;
    private final DiagonalMapper diagonalMapper;

    public List<DiagonalDto> getDiagonals(){
        return diagonalMapper.toDtoList(diagonalRepository.findAll());
    }
    public DiagonalDto addDiagonal(DiagonalDto diagonal){
        return diagonalMapper.toDto(diagonalRepository.save(diagonalMapper.toModel(diagonal)));
    }
    public DiagonalDto getDiagonal(Long id){
        return diagonalMapper.toDto(diagonalRepository.findById(id).orElseThrow());
    }
    public DiagonalDto editDiagonal(DiagonalDto diagonal){
        return diagonalMapper.toDto(diagonalRepository.save(diagonalMapper.toModel(diagonal)));
    }
    public void deleteDiagonal(Long id){
        diagonalRepository.deleteById(id);
    }
}
