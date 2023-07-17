package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.NotebookDto;
import spring.security.security.dto.PhoneDto;
import spring.security.security.mapper.NotebookMapperImpl;
import spring.security.security.mapper.PhoneMapperImpl;
import spring.security.security.model.Item;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.model.Phone.Phone;
import spring.security.security.repository.ItemRepository;
import spring.security.security.repository.NotebookRepository;
import spring.security.security.repository.PhoneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;
    public final PhoneMapperImpl phoneMapper;
    private final ItemRepository itemRepository;

    public List<PhoneDto> getPhones(){

        return phoneMapper.toDtoList(phoneRepository.findAll()) ;
    }
    public PhoneDto addPhone(PhoneDto phoneDto){
        Phone phone = phoneMapper.toModel(phoneDto);
        Phone savePhone = phoneRepository.save(phone);

        Item item = phone.getItem();
        item.setPhoneId(savePhone.getId());
        itemRepository.save(item);

        return phoneMapper.toDto(savePhone);
    }

    public PhoneDto getPhone(Long id){
        return phoneMapper.toDto(phoneRepository.findById(id).orElseThrow()) ;
    }
    public PhoneDto editPhone(PhoneDto phoneDto){

        itemRepository.save(phoneDto.getItem());
        return phoneMapper.toDto(phoneRepository.save(phoneMapper.toModel(phoneDto))) ;
    }
    public void deletePhone(Long id){
        phoneRepository.deleteById(id);
    }

}
