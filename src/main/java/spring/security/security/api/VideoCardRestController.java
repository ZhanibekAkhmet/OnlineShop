package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.VideoCardDto;
import spring.security.security.model.Laptop.VideoCard;
import spring.security.security.service.VideoCardService;

import java.util.List;

@RestController
@RequestMapping(value = "/videoCard")
@RequiredArgsConstructor
public class VideoCardRestController {
    private final VideoCardService videoCardService;
    @GetMapping
    public List<VideoCardDto> videoCardList(){
        return videoCardService.getVideoCards();
    }
    @GetMapping(value = "{id}")
    public VideoCardDto   getVideoCard(@PathVariable(name = "id") Long id){
        return videoCardService.getVideoCard(id);
    }
    @PostMapping
    public VideoCardDto addVideoCard(@RequestBody VideoCardDto videoCard){
        return videoCardService.addVideoCard(videoCard);
    }
    @PutMapping
    public VideoCardDto editVideoCard(@RequestBody VideoCardDto videoCard){
        return videoCardService.editVideoCard(videoCard);
    }
    @DeleteMapping(value = "{id}")
    public void deleteVideoCard(@PathVariable(name = "id")Long id){
        videoCardService.deleteVideoCard(id);
    }
}
