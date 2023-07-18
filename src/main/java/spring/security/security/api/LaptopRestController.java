package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.LaptopDto;
import spring.security.security.service.LaptopService;
import java.util.List;

@RestController
@RequestMapping(value = "/laptop")
@RequiredArgsConstructor
public class LaptopRestController {
    private final LaptopService laptopService;
    @GetMapping
    public List<LaptopDto> laptopList(){
        return laptopService.getLaptops();
    }
    @GetMapping(value = "{id}")
    public LaptopDto getLaptop(@PathVariable(name = "id") Long id){
        return laptopService.getLaptopByItem(id);
    }
    @PostMapping
    public LaptopDto addLaptop(@RequestBody LaptopDto laptopDto){
        return laptopService.addLaptop(laptopDto);
    }
    @PutMapping
    public LaptopDto editLaptop(@RequestBody LaptopDto laptopDto){
        return laptopService.editLaptop(laptopDto);
    }
    @DeleteMapping(value = "{id}")
    public void deleteLaptop(@PathVariable(name = "id")Long id){
        laptopService.deleteLaptop(id);
    }
}