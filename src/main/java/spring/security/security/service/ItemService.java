package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.security.security.dto.ItemDto;
import spring.security.security.mapper.ItemMapperImpl;
import spring.security.security.repository.ItemRepository;
import spring.security.security.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    public final ItemMapperImpl itemMapper;

    public List<ItemDto> getItems(){
        return itemMapper.toDtoList(itemRepository.findAll());
    }
    public List<ItemDto> getItemsModel(Long id){
        return itemMapper.toDtoList(itemRepository.findAllByNotebookModel_Id(id));
    }
//    public List<ItemDto> getItemsModelPrice(Long id){
//        return itemMapper.toDtoList(itemRepository.findAllByNotebookModel_IdOrderByPrice(id));
//    }
//    public List<ItemDto> getItemsModelPriceDesc(Long id){
//        return itemMapper.toDtoList(itemRepository.findAllByNotebookModel_IdOrderBOrderByPriceDesc(id));
//    }
    public List<ItemDto> getItemsSortByPrice(){
        return itemMapper.toDtoList(itemRepository.findAll(Sort.by("price")));
    }
    public List<ItemDto> getItemsSortDescPrice(){
        return itemMapper.toDtoList(itemRepository.findAll(Sort.by(Sort.Order.desc("price"))));
    }
    public ItemDto getItem(Long id){
        return itemMapper.toDto(itemRepository.findById(id).orElseThrow());
    }
    public List<ItemDto> getItemsCategories(Long categoryId){
        return itemMapper.toDtoList(itemRepository.findByCategoriesId(categoryId));
    }

}
