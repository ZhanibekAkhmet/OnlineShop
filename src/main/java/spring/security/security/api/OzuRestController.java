package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Memory;
import spring.security.security.model.Ozu;
import spring.security.security.service.MemoryService;
import spring.security.security.service.OzuService;

import java.util.List;

@RestController
@RequestMapping(value = "/ozu")
@RequiredArgsConstructor
public class OzuRestController {
    private final OzuService ozuService;
    @GetMapping
    public List<Ozu> ozuList(){
        return ozuService.getAllOzu();
    }
    @GetMapping(value = "{id}")
    public Ozu   getOzu(@PathVariable(name = "id") Long id){
        return ozuService.getOzu(id);
    }
    @PostMapping
    public Ozu addOzu(@RequestBody Ozu ozu){
        return ozuService.addOzu(ozu);
    }
    @PutMapping
    public Ozu editOzu(@RequestBody Ozu ozu){
        return ozuService.editOzu(ozu);
    }
    @DeleteMapping(value = "{id}")
    public void deleteOzu(@PathVariable(name = "id")Long id){
        ozuService.deleteOzu(id);
    }
}
