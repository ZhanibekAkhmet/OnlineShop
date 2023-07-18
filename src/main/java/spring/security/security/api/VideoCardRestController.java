package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.Laptop.VideoCard;
import spring.security.security.service.VideoCardService;

import java.util.List;

@RestController
@RequestMapping(value = "/videoCard")
@RequiredArgsConstructor
public class VideoCardRestController {
    private final VideoCardService videoCardService;
    @GetMapping
    public List<VideoCard> videoCardList(){
        return videoCardService.getVideoCards();
    }
    @GetMapping(value = "{id}")
    public VideoCard   getVideoCard(@PathVariable(name = "id") Long id){
        return videoCardService.getVideoCard(id);
    }
    @PostMapping
    public VideoCard addVideoCard(@RequestBody VideoCard videoCard){
        return videoCardService.addVideoCard(videoCard);
    }
    @PutMapping
    public VideoCard editVideoCard(@RequestBody VideoCard videoCard){
        return videoCardService.editVideoCard(videoCard);
    }
    @DeleteMapping(value = "{id}")
    public void deleteVideoCard(@PathVariable(name = "id")Long id){
        videoCardService.deleteVideoCard(id);
    }
}
