package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.PhoneDto;
import spring.security.security.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping(value = "/phone")
@RequiredArgsConstructor
public class PhoneRestController {
    private final PhoneService phoneService;
    @GetMapping
    public List<PhoneDto> phoneList(){
        return phoneService.getPhones();
    }
    @GetMapping(value = "{id}")
    public PhoneDto   getPhone(@PathVariable(name = "id") Long id){
        return phoneService.getPhone(id);
    }
    @PostMapping
    public PhoneDto addPhone(@RequestBody PhoneDto phoneDto){
        return phoneService.addPhone(phoneDto);
    }
    @PutMapping
    public PhoneDto editPhone(@RequestBody PhoneDto phoneDto){
        return phoneService.editPhone(phoneDto);
    }
    @DeleteMapping(value = "{id}")
    public void deletePhone(@PathVariable(name = "id")Long id){
        phoneService.deletePhone(id);
    }
}