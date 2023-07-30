package spring.security.security.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@SessionScope

public class ShoppingCart {
    private Map<Long, Item> itemMap;
    private Map<Long, Integer> itemQuantityMap;


    public ShoppingCart() {
        this.itemMap = new HashMap<>();
        this.itemQuantityMap = new HashMap<>();
    }

    public void addItem(Item item) {
        Long itemId = item.getId();
        if (itemMap.containsKey(itemId)) {
            int quantity = itemQuantityMap.get(itemId);
            itemQuantityMap.put(itemId, quantity + 1);
        } else {
            itemMap.put(itemId, item);
            itemQuantityMap.put(itemId, 1);
        }
    }

    public void removeItem(Item item) {
        Long itemId = item.getId();
        if (itemMap.containsKey(itemId)) {
            int quantity = itemQuantityMap.get(itemId);
            if (quantity > 1) {
                itemQuantityMap.put(itemId, quantity - 1);
            } else {
                itemMap.remove(itemId);
                itemQuantityMap.remove(itemId);
            }
        }
    }

    public int getItemQuantity(Item item) {
        Long itemId = item.getId();
        return itemQuantityMap.getOrDefault(itemId, 0);
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemMap.values());
    }
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Long, Item> entry : itemMap.entrySet()) {
            Item item = entry.getValue();
            int quantity = itemQuantityMap.get(item.getId());
            BigDecimal itemTotal = item.getPrice().multiply(new BigDecimal(quantity));
            total = total.add(itemTotal);
        }
        return total;
    }
    public void clearCart() {
        itemMap.clear();
        itemQuantityMap.clear();
    }
    public void removeItemById(Long itemId) {
        if (itemMap.containsKey(itemId)) {
            itemMap.remove(itemId);
            itemQuantityMap.remove(itemId);
        }
    }
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int quantity : itemQuantityMap.values()) {
            totalQuantity += quantity;
        }
        return totalQuantity;
    }
}
