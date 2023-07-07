package spring.security.security.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.Notebooks.NotebookModel;
import spring.security.security.model.Notebooks.Processor;
import spring.security.security.model.Notebooks.VideoCard;

import java.math.BigDecimal;

@Getter
@Setter
public class NotebookDto {
    private Long id;
    @ManyToOne
    private NotebookModel notebookModel;
    private String title;
    private String description;
    private BigDecimal price;
    @ManyToOne
    private Processor processor;
    @ManyToOne
    private VideoCard videoCard;
    private int memory;
    private int ozu;
    private double diagonal;
}
