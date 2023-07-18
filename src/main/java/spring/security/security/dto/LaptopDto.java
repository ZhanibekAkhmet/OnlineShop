package spring.security.security.dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import spring.security.security.model.Item;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.model.Laptop.VideoCard;



@Getter
@Setter
public class LaptopDto {
    private Long id;
    @ManyToOne
    private Processor processor;
    @ManyToOne
    private VideoCard videoCard;
    private int memory;
    private int ozu;
    private double diagonal;
    @OneToOne
    private Item item;
}
