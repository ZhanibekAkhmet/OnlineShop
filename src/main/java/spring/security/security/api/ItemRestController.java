package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.security.security.dto.ItemDto;
import spring.security.security.dto.LaptopDto;
import spring.security.security.service.ItemService;
import spring.security.security.service.UploadImageService;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;
    private final UploadImageService uploadImageService;
    @GetMapping
    public List<ItemDto> itemdList(){
        return itemService.getItems();
    }
    @GetMapping(value = "/expensive")
    public List<ItemDto> expensiveList(){
        return itemService.getItemsSortDescPrice();
    }
    @GetMapping(value = "/cheap")
    public List<ItemDto> cheapList(){
        return itemService.getItemsSortByPrice();
    }
    @GetMapping(value = "/search")
    public List<ItemDto> searchItemList(@RequestParam(required = false) String query){
        if (query == null || query.isEmpty()) {
            return itemService.getItems();
        } else {
            return itemService.searchItems(query);
        }
    }
    @GetMapping(value = "/model/{id}")
    public List<ItemDto> modelItemList(@PathVariable(name = "id") Long id){
        return itemService.getItemsModel(id);
    }
    @GetMapping(value = "/model/cheap/{id}")
    public List<ItemDto> modelItemListCheap(@PathVariable(name = "id") Long id){
        return itemService.getItemsModelsSortByPrice(id);
    }
    @GetMapping(value = "/model/expensive/{id}")
    public List<ItemDto> modelItemListExpensive(@PathVariable(name = "id") Long id){
        return itemService.getItemsModelsSortByPriceDesc(id);
    }
    @GetMapping(value = "{id}")
    public List<ItemDto> categoriesList(@PathVariable(name = "id") Long id){
        return itemService.getItemsCategories(id);
    }
    @GetMapping(value = "/getOne/{id}")
    public ItemDto getItem(@PathVariable(name = "id") Long id){
        return itemService.getItem(id);
    }
    @GetMapping(value = "/cheap/{id}")
    public List<ItemDto> categoriesListByPrice(@PathVariable(name = "id") Long id){
        return itemService.getItemsCategoriesSortByPrice(id);
    }
    @GetMapping(value = "/expensive/{id}")
    public List<ItemDto> categoriesListByPriceDesc(@PathVariable(name = "id") Long id){
        return itemService.getItemsCategoriesSortByPriceDesc(id);
    }
    @PostMapping(value = "/upload")
    public void addImage(@RequestParam(name = "image") MultipartFile file,
                         @RequestParam(name = "id") Long id){
            uploadImageService.UploadPicture(file,id);
    }

    @PostMapping
    public ItemDto addItemDto(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }
    @PutMapping
    public ItemDto editItemDto(@RequestBody ItemDto itemDto){
        return itemService.editItemDto(itemDto);
    }
    @DeleteMapping(value = "{id}")
    public void deleteItemDto(@PathVariable(name = "id")Long id){
        itemService.deleteItem(id);
    }
}
