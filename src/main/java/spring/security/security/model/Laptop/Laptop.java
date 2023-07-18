package spring.security.security.model.Laptop;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.Item;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    @ManyToOne
    private Processor processor;
    @ManyToOne
    private VideoCard videoCard;
    private int memory;
    private int ozu;
    private double diagonal;

}
