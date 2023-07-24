package spring.security.security.mapper;

import org.mapstruct.Mapper;
import spring.security.security.dto.ModelDto;
import spring.security.security.dto.OrderDto;
import spring.security.security.model.Laptop.Model;
import spring.security.security.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

        OrderDto toDto(Order order);

        Order toModel(OrderDto orderDto);
        List<OrderDto> toDtoList(List<Order> orderList);
        List<Order> toModelList(List<OrderDto> orderDtoList);
}
