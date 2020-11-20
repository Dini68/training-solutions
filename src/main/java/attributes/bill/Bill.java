package attributes.bill;

import java.util.List;

public class Bill {

    private List<Item> items;

    public void addItem(Item item){
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
