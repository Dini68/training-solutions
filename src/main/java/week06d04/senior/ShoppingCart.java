package week06d04.senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(String name, int quantity) {
        boolean isFound = false;
        for (Item item: items) {
            if (item.getName().equals(name)) {
                item.addQuantity(quantity);
                isFound = true;
            }
        }
        if (!isFound) {
            items.add(new Item(name, quantity));
        }
    }

    public int getItem(String name) {
        int result = 0;
        for (Item item: items) {
            if (item.getName().equals(name)) {
                result = item.getQuantity();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("alma", 100);
        sc.addItem("körte", 100);
        sc.addItem("alma", 100);
        sc.addItem("körte", 100);
        sc.addItem("alma", 100);
        sc.addItem("alma", 100);
        System.out.println(sc.getItem("alma"));
        System.out.println(sc.getItem("körte"));
        System.out.println(sc.getItem("barack"));
    }
}
