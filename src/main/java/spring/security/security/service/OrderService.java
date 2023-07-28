package spring.security.security.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.security.security.dto.OrderDto;
import spring.security.security.mapper.OrderMapper;
import spring.security.security.model.*;
import spring.security.security.repository.OrderItemRepository;
import spring.security.security.repository.OrderRepository;
import spring.security.security.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderService {
//    @Autowired
    private final OrderRepository orderRepository;
//    @Autowired
    private final   OrderMapper orderMapper;
//    @Autowired
    private final   ShoppingCart shoppingCart;

    private final UserRepository userRepository;
//    @Autowired
    private final OrderItemRepository orderItemRepository;


    public OrderDto createOrderFromShoppingCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        List<Item> items = shoppingCart.getItems();

        if (items.isEmpty()) {
            // Действия при пустой корзине
            // Например, можно вывести сообщение пользователю или выполнить другие действия
            // Здесь можно обработать ситуацию с пустой корзиной и предоставить информацию о пустой корзине
            // или выполнить другие операции, которые следует предпринять в этом случае.
            return null; // Или вернуть какое-то значение по умолчанию или null
        } else {
            List<OrderItem> orderItems = new ArrayList<>();
            for (Item item : items) {
                int quantity = shoppingCart.getItemQuantity(item);
                OrderItem orderItem = new OrderItem();
                orderItem.setItem(item);
                orderItem.setQuantity(quantity);
                orderItems.add(orderItem);
            }

            OrderDto order = new OrderDto();
            order.setUser(user);
            order.setOrderItems(orderItems);
            order.setTotal(shoppingCart.getTotal());
            order.setCreatedDate(LocalDateTime.now());
            order.setStatus(0);

            shoppingCart.clearCart();
            return orderMapper.toDto(orderRepository.save(orderMapper.toModel(order)));
        }
    }

    public List<OrderDto> getOrders() {
        return orderMapper.toDtoList(orderRepository.findAll(Sort.by("createdDate")));
    }
    public List<OrderDto> getOrdersStatus(int statusId) {
        return orderMapper.toDtoList(orderRepository.findAllByStatusOrderByCreatedDate(statusId));
    }
    public List<OrderDto> getSearchOrder(String query) {
        return orderMapper.toDtoList(orderRepository.findByUserEmailIgnoreCaseOrUserFullNameIgnoreCaseOrUserPhoneIgnoreCase(query,query,query));
    }
    public List<OrderDto> getOrdersUser(Long id) {
        return orderMapper.toDtoList(orderRepository.findAllByUserId(id));
    }
    public List<OrderItem>getItems(){
        return orderItemRepository.findAll();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public OrderDto updateOrderStatus(Long orderId, Integer status) {
        OrderDto order = orderMapper.toDto(orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found")));
        order.setStatus(status);
        return orderMapper.toDto(orderRepository.save(orderMapper.toModel(order)));
    }
}
