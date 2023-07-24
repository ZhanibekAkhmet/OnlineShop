package spring.security.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.security.model.CartItem;
import spring.security.security.model.Item;
import spring.security.security.model.ShoppingCart;
import spring.security.security.repository.ItemRepository;


import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCardRestController {
    @Autowired
    private ShoppingCart shoppingCart;
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/add/{id}")
    public void addItem(@PathVariable(name = "id") Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        shoppingCart.addItem(item);
    }

    @PostMapping("/remove/{id}")
    public void removeItem(@PathVariable(name = "id") Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        shoppingCart.removeItem(item);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable(name = "id") Long id) {
        shoppingCart.removeItemById(id);
    }
    @DeleteMapping("/delete")
    public void deleteItem() {
        shoppingCart.clearCart();
    }
    @GetMapping("/quantity")
    public int getItemQuantity() {
        return shoppingCart.getTotalQuantity();
    }
    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getItems() {
    List<Item> items = shoppingCart.getItems();
    List<CartItem> cartItems = new ArrayList<>();
    for (Item item : items) {
        int quantity = shoppingCart.getItemQuantity(item);
        CartItem cartItem = new CartItem(item, quantity);
        cartItems.add(cartItem);
    }
        return ResponseEntity.ok(cartItems);
    }
    @GetMapping("/total")
    public BigDecimal getTotal() {
        return shoppingCart.getTotal();
    }


}
