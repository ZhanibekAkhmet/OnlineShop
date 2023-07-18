package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.security.security.dto.ItemDto;
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
    @GetMapping(value = "/model/{id}")
    public List<ItemDto> modelItemList(@PathVariable(name = "id") Long id){
        return itemService.getItemsModel(id);
    }
//    @GetMapping(value = "/modelPrice/{id}")
//    public List<ItemDto> modelItemListPriceBy(@PathVariable(name = "id") Long id){
//        return itemService.getItemsModelPrice(id);
//    }
//    @GetMapping(value = "/modelPriceDesc/{id}")
//    public List<ItemDto> modelItemListPriceDesc(@PathVariable(name = "id") Long id){
//        return itemService.getItemsModelPriceDesc(id);
//    }
    @GetMapping(value = "{id}")
    public List<ItemDto> categoriesList(@PathVariable(name = "id") Long id){
        return itemService.getItemsCategories(id);
    }
    @PostMapping(value = "/upload")
    public void addImage(@RequestParam(name = "image") MultipartFile file,
                         @RequestParam(name = "id") Long id){
            uploadImageService.UploadPicture(file,id);
    }
}
