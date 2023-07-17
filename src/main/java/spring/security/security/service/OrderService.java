package spring.security.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.security.model.*;
import spring.security.security.repository.OrderItemRepository;
import spring.security.security.repository.OrderRepository;
import spring.security.security.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    private  ShoppingCart shoppingCart;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    // In OrderService
    public Order createOrderFromShoppingCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Item> items = shoppingCart.getItems();
        List<OrderItem> orderItems = new ArrayList<>();
        for (Item item : items) {
            int quantity = shoppingCart.getItemQuantity(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(quantity);
            orderItems.add(orderItem);
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotal(shoppingCart.getTotal());
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus(0);

        shoppingCart.clearCart();
        return orderRepository.save(order);
    }
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    public List<Order> getOrdersUser(Long id) {
        return orderRepository.findAllByUserId(id);
    }
    public List<OrderItem>getItems(){
        return orderItemRepository.findAll();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order updateOrderStatus(Long orderId, Integer status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
