package spring.security.security.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.Item;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String text;
    private String userN;
    @ManyToOne
    private Item item;
    private LocalDateTime time;
}
