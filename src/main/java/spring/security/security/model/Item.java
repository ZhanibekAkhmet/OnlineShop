package spring.security.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.Laptop.Model;

import java.math.BigDecimal;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
//    @JoinColumn(name = "notebook_id")
//    private Long notebookId;
//    @JoinColumn(name = "phone_id")
//    private Long phoneId;
    @ManyToOne
    private Categories categories;
    @ManyToOne
    private Model model;
    private String image;

}
