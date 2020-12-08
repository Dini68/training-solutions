package introinheritance.itembasketshoppingbasket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basket{

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(String barcode) {
        Item delItem = new Item("",0,0);
        boolean isFound = false;
        for (Item it: items) {
            if (it.getBarcode().equals(barcode)){
                delItem = it;
                isFound = true;
            }
        }
        if (isFound) items.remove(delItem);
    }
    public void clearBasket() {
        this.items.clear();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }
}
