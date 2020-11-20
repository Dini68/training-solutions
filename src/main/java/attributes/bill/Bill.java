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

    public void calculateTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).quantity * items.get(i).price;
        }
        System.out.println(totalPrice);
    }
}
