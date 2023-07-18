package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.PhoneDto;
//import spring.security.security.mapper.NotebookMapperImpl;
import spring.security.security.mapper.PhoneMapperImpl;
import spring.security.security.model.Phone.Phone;
import spring.security.security.repository.CommentRepository;
import spring.security.security.repository.ItemRepository;
import spring.security.security.repository.PhoneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;
    public final PhoneMapperImpl phoneMapper;
    private final CommentRepository commentRepository;

    public List<PhoneDto> getPhones(){

        return phoneMapper.toDtoList(phoneRepository.findAll()) ;
    }
    public PhoneDto addPhone(PhoneDto phoneDto){
        Phone phone = phoneMapper.toModel(phoneDto);
        Phone savePhone = phoneRepository.save(phone);

        return phoneMapper.toDto(savePhone);
    }

    public PhoneDto getPhone(Long id){
        return phoneMapper.toDto(phoneRepository.findById(id).orElseThrow()) ;
    }
    public PhoneDto getPhoneByItem(Long id){
        return phoneMapper.toDto(phoneRepository.findByItem_Id(id)) ;
    }
    public PhoneDto editPhone(PhoneDto phoneDto){

        return phoneMapper.toDto(phoneRepository.save(phoneMapper.toModel(phoneDto))) ;
    }
    public void deletePhone(Long id){
        Long itemId = getPhone(id).getItem().getId();
        commentRepository.deleteByItem_Id(itemId);
        phoneRepository.deleteById(id);
    }

}
