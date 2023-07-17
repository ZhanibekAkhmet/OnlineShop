package spring.security.security.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CartItem {

        private Item item;
        private int quantity;

        public CartItem(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }
         public CartItem() {
         }

}
