package spring.security.security.model.Phone;

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
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    private int memory;
    private int ozu;
    @ManyToOne
    private PhoneProcessor phoneProcessor;
    private int photo;
    private int frontPhoto;
    private double diagonal;
    private int sim;
    private String OS;
    private int weight;
}
