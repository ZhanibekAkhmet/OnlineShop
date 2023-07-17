package spring.security.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.security.security.model.*;

import spring.security.security.repository.ItemRepository;
import spring.security.security.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    @Autowired
    private  OrderService orderService;
    @Autowired
    private ItemRepository itemRepository;
    @PostMapping
    public ResponseEntity<Order> createOrderFromShoppingCart(@RequestParam Long userId) {
        Order order = orderService.createOrderFromShoppingCart(userId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<List<Order>> getOrdersUser(@PathVariable Long id) {
        List<Order> orders = orderService.getOrdersUser(id);
        return ResponseEntity.ok(orders);
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam Integer status) {
        Order updatedOrder = orderService.updateOrderStatus(orderId, status);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
}


