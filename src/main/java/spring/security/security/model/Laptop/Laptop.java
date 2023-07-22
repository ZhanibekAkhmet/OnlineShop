package spring.security.security.model.Laptop;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Item;
import spring.security.security.model.Memory;
import spring.security.security.model.Ozu;

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
    @ManyToOne
    private Memory memory;
    @ManyToOne
    private Ozu ozu;
    @ManyToOne
    private Diagonal diagonal;

}
