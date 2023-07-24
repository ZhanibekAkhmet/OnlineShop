package spring.security.security.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import spring.security.security.model.OrderItem;
import spring.security.security.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private BigDecimal total;
    private LocalDateTime createdDate;
    @ManyToOne
    private User user;
    @Column(name = "status")
    private int status;
}
