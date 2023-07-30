package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.OzuDto;
import spring.security.security.service.OzuService;

import java.util.List;

@RestController
@RequestMapping(value = "/ozu")
@RequiredArgsConstructor
public class OzuRestController {
    private final OzuService ozuService;
    @GetMapping
    public List<OzuDto> ozuList(){
        return ozuService.getAllOzu();
    }
    @GetMapping(value = "{id}")
    public OzuDto   getOzu(@PathVariable(name = "id") Long id){
        return ozuService.getOzu(id);
    }
    @PostMapping
    public OzuDto addOzu(@RequestBody OzuDto ozu){
        return ozuService.addOzu(ozu);
    }
    @PutMapping
    public OzuDto editOzu(@RequestBody OzuDto ozu){
        return ozuService.editOzu(ozu);
    }
    @DeleteMapping(value = "{id}")
    public void deleteOzu(@PathVariable(name = "id")Long id){
        ozuService.deleteOzu(id);
    }
}
