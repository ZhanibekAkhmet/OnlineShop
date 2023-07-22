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
    @ManyToOne
    private Categories categories;
    @ManyToOne
    private Model model;
    private String image;
    private double weight;
    private String color;
}
