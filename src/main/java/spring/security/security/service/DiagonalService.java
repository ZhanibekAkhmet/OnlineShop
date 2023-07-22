package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Memory;
import spring.security.security.repository.DiagonalRepository;
import spring.security.security.repository.MemoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagonalService {
    private final DiagonalRepository diagonalRepository;

    public List<Diagonal> getDiagonals(){
        return diagonalRepository.findAll();
    }
    public Diagonal addDiagonal(Diagonal diagonal){
        return diagonalRepository.save(diagonal);
    }
    public Diagonal getDiagonal(Long id){
        return diagonalRepository.findById(id).orElseThrow();
    }
    public Diagonal editDiagonal(Diagonal diagonal){
        return diagonalRepository.save(diagonal);
    }
    public void deleteDiagonal(Long id){
        diagonalRepository.deleteById(id);
    }
}
