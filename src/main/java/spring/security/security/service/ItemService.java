package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.security.security.dto.ItemDto;
import spring.security.security.dto.LaptopDto;
import spring.security.security.mapper.ItemMapper;
import spring.security.security.mapper.ItemMapperImpl;
import spring.security.security.model.Item;
import spring.security.security.model.Laptop.Laptop;
import spring.security.security.repository.CommentRepository;
import spring.security.security.repository.ItemRepository;
import spring.security.security.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public final ItemMapperImpl itemMapper;
    private final CommentRepository commentRepository;

    public List<ItemDto> getItems(){
        return itemMapper.toDtoList(itemRepository.findAll());
    }
    public List<ItemDto> getItemsModel(Long id){
        return itemMapper.toDtoList(itemRepository.findAllByModel_Id(id));
    }
    public List<ItemDto> getItemsModelsSortByPrice(Long id){
        return itemMapper.toDtoList(itemRepository.findByModel_IdOrderByPrice(id));
    }
    public List<ItemDto> getItemsModelsSortByPriceDesc(Long id){
        return itemMapper.toDtoList(itemRepository.findByModel_IdOrderByPriceDesc(id));
    }
    public List<ItemDto> getItemsSortByPrice(){
        return itemMapper.toDtoList(itemRepository.findAll(Sort.by("price")));
    }
    public List<ItemDto> getItemsSortDescPrice(){
        return itemMapper.toDtoList(itemRepository.findAll(Sort.by(Sort.Order.desc("price"))));
    }
    public ItemDto getItem(Long id){
        return itemMapper.toDto(itemRepository.findById(id).orElseThrow());
    }
    public List<ItemDto> getItemsCategoriesSortByPrice(Long categoryId){
        return itemMapper.toDtoList(itemRepository.findByCategoriesIdOrderByPrice(categoryId));
    }
    public List<ItemDto> getItemsCategoriesSortByPriceDesc(Long categoryId){
        return itemMapper.toDtoList(itemRepository.findByCategoriesIdOrderByPriceDesc(categoryId));
    }
    public List<ItemDto> getItemsCategories(Long categoryId){
        return itemMapper.toDtoList(itemRepository.findByCategoriesId(categoryId));
    }
    public void deleteItem(Long ItemId){
        commentRepository.deleteByItem_Id(ItemId);
        itemRepository.deleteById(ItemId);
    }
    public ItemDto addItem(ItemDto itemDto){
        Item item = itemMapper.toModel(itemDto);
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }
    public ItemDto editItemDto(ItemDto itemDto){

        return itemMapper.toDto(itemRepository.save(itemMapper.toModel(itemDto))) ;
    }
    public List<ItemDto> searchItems(String query) {

            String[] parts = query.split(" ");
            if (parts.length == 1) {
                return itemMapper.toDtoList(itemRepository.findByNameContainingIgnoreCaseOrModelNameContainingIgnoreCase(parts[0], parts[0]));
            } else {
                return itemMapper.toDtoList(itemRepository.findByNameContainingIgnoreCaseOrModelNameContainingIgnoreCase(parts[0], parts[1]));
            }

//        return itemMapper.toDtoList(itemRepository.findByNameContainingIgnoreCaseOrModelNameContainingIgnoreCase(query, query));
    }
}
