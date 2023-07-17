package spring.security.security.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.Item;
import spring.security.security.model.Phone.PhoneProcessor;


@Getter
@Setter
public class PhoneDto {
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    private int memory;
    private int ozu;
    private PhoneProcessor phoneProcessor;
    private int photo;
    private int frontPhoto;
    private double diagonal;
    private int sim;
    private String OS;
    private int weight;
}
