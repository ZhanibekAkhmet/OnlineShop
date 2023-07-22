package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Memory;
import spring.security.security.model.Ozu;
import spring.security.security.repository.MemoryRepository;
import spring.security.security.repository.OzuRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OzuService {
    private final OzuRepository ozuRepository;

    public List<Ozu> getAllOzu(){
        return ozuRepository.findAll();
    }
    public Ozu addOzu(Ozu ozu){
        return ozuRepository.save(ozu);
    }
    public Ozu getOzu(Long id){
        return ozuRepository.findById(id).orElseThrow();
    }
    public Ozu editOzu(Ozu ozu){
        return ozuRepository.save(ozu);
    }
    public void deleteOzu(Long id){
        ozuRepository.deleteById(id);
    }
}
