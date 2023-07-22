package spring.security.security.dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import spring.security.security.model.Diagonal;
import spring.security.security.model.Item;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.model.Laptop.VideoCard;
import spring.security.security.model.Memory;
import spring.security.security.model.Ozu;


@Getter
@Setter
public class LaptopDto {
    private Long id;
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
    @OneToOne
    private Item item;
}
