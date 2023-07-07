package spring.security.security.dto;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoCardDto {
    private Long id;
    private String model;
}
