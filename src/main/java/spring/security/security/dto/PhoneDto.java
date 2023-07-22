package spring.security.security.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Item;
import spring.security.security.model.Memory;
import spring.security.security.model.Ozu;
import spring.security.security.model.Phone.PhoneProcessor;


@Getter
@Setter
public class PhoneDto {
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    @ManyToOne
    private Memory memory;
    @ManyToOne
    private Ozu ozu;
    private PhoneProcessor phoneProcessor;
    private int photo;
    private int frontPhoto;
    @ManyToOne
    private Diagonal diagonal;
    private int sim;
    private String OS;
}
