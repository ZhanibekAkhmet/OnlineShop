package spring.security.security.model.Notebooks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private NotebookModel notebookModel;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne
    private Processor processor;
    @ManyToOne
    private VideoCard videoCard;
    private int memory;
    private int ozu;
    private double diagonal;
    private String image;
}
