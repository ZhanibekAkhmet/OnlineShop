package spring.security.security.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.Categories;

import spring.security.security.model.Notebooks.NotebookModel;

import java.math.BigDecimal;
@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @JoinColumn(name = "notebook_id")
    private Long notebookId;
    @JoinColumn(name = "phone_id")
    private Long phoneId;
    @ManyToOne
    private Categories categories;
    @ManyToOne
    private NotebookModel notebookModel;
    private String image;
}
