package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.LaptopDto;
import spring.security.security.mapper.LaptopMapper;
import spring.security.security.model.Item;
import spring.security.security.model.Laptop.Laptop;
import spring.security.security.repository.CommentRepository;

import spring.security.security.repository.LaptopRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;
    private final LaptopMapper laptopMapper;
    private final CommentRepository commentRepository;

    public List<LaptopDto> getLaptops(){

        return laptopMapper.toDtoList(laptopRepository.findAll()) ;
    }
    public LaptopDto addLaptop(LaptopDto laptopDto){
        Laptop laptop = laptopMapper.toModel(laptopDto);
        Laptop savedLaptop = laptopRepository.save(laptop);
        return laptopMapper.toDto(savedLaptop);
    }

    public LaptopDto getLaptop(Long id){
        return laptopMapper.toDto(laptopRepository.findById(id).orElseThrow()) ;
    }
    public LaptopDto getLaptopByItem(Long id){
        return laptopMapper.toDto(laptopRepository.findByItem_Id(id)) ;
    }
    public LaptopDto editLaptop(LaptopDto laptopDto){

        return laptopMapper.toDto(laptopRepository.save(laptopMapper.toModel(laptopDto))) ;
    }
    public void deleteLaptop(Long id){

        LaptopDto laptopDto = getLaptop(id);
        try{
            Item item = laptopDto.getItem();
            if (item != null) {
                Long itemId = item.getId();
                commentRepository.deleteByItem_Id(itemId);
            }
            laptopRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
