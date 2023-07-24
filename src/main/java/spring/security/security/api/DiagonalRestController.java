package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.DiagonalDto;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Ozu;
import spring.security.security.service.DiagonalService;
import spring.security.security.service.OzuService;

import java.util.List;

@RestController
@RequestMapping(value = "/diagonal")
@RequiredArgsConstructor
public class DiagonalRestController {
    private final DiagonalService diagonalService;
    @GetMapping
    public List<DiagonalDto> diagonalList(){
        return diagonalService.getDiagonals();
    }
    @GetMapping(value = "{id}")
    public DiagonalDto   getDiagonal(@PathVariable(name = "id") Long id){
        return diagonalService.getDiagonal(id);
    }
    @PostMapping
    public DiagonalDto addDiagonal(@RequestBody DiagonalDto diagonal){
        return diagonalService.addDiagonal(diagonal);
    }
    @PutMapping
    public DiagonalDto editDiagonal(@RequestBody DiagonalDto diagonal){
        return diagonalService.editDiagonal(diagonal);
    }
    @DeleteMapping(value = "{id}")
    public void deleteDiagonal(@PathVariable(name = "id")Long id){
        diagonalService.deleteDiagonal(id);
    }
}
