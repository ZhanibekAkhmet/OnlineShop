package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Laptop.VideoCard;
import spring.security.security.repository.VideoCardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoCardService {
    private final VideoCardRepository videoCardRepository;

    public List<VideoCard> getVideoCards(){
        return videoCardRepository.findAll();
    }
    public VideoCard addVideoCard(VideoCard videoCard){
        return videoCardRepository.save(videoCard);
    }
    public VideoCard getVideoCard(Long id){
        return videoCardRepository.findById(id).orElseThrow();
    }
    public VideoCard editVideoCard(VideoCard videoCard){
        return videoCardRepository.save(videoCard);
    }
    public void deleteVideoCard(Long id){
        videoCardRepository.deleteById(id);
    }
}
