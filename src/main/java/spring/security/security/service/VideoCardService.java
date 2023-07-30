package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.VideoCardDto;
import spring.security.security.mapper.VideoCardMapper;
import spring.security.security.repository.VideoCardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoCardService {
    private final VideoCardRepository videoCardRepository;
    private final VideoCardMapper videoCardMapper;

    public List<VideoCardDto> getVideoCards(){
        return videoCardMapper.toDtoList(videoCardRepository.findAll());
    }
    public VideoCardDto addVideoCard(VideoCardDto videoCard){
        return videoCardMapper.toDto(videoCardRepository.save(videoCardMapper.toModel(videoCard)));
    }
    public VideoCardDto getVideoCard(Long id){
        return videoCardMapper.toDto(videoCardRepository.findById(id).orElseThrow());
    }
    public VideoCardDto editVideoCard(VideoCardDto videoCard){
        return videoCardMapper.toDto(videoCardRepository.save(videoCardMapper.toModel(videoCard)));
    }
    public void deleteVideoCard(Long id){
        videoCardRepository.deleteById(id);
    }
}
