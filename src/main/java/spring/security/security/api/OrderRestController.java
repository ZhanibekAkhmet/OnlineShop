package spring.security.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.security.security.dto.OrderDto;

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
public ResponseEntity<OrderDto> createOrderFromShoppingCart(@RequestParam Long userId) {
    OrderDto order = orderService.createOrderFromShoppingCart(userId);
    if (order == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping (value = "/status/{statusId}")
    public ResponseEntity<List<OrderDto>> getOrdersByStatus(@PathVariable int statusId) {
        List<OrderDto> orders = orderService.getOrdersStatus(statusId);
        return ResponseEntity.ok(orders);
    }
    @GetMapping (value = "/search")
    public ResponseEntity<List<OrderDto>> getOrdersSearch(@RequestParam(required = false) String query) {
        List<OrderDto> orders;
        if (query == null || query.isEmpty()) {
            orders = orderService.getOrders();
        } else {
            orders = orderService.getSearchOrder(query);
        }
        return ResponseEntity.ok(orders);

    }
    @GetMapping(value = "{id}")
    public ResponseEntity<List<OrderDto>> getOrdersUser(@PathVariable Long id) {
        List<OrderDto> orders = orderService.getOrdersUser(id);
        return ResponseEntity.ok(orders);
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable Long orderId, @RequestParam Integer status) {
        OrderDto updatedOrder = orderService.updateOrderStatus(orderId, status);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
}


