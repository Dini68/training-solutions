package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    private List<Item> getItems() {
        return items;
    }

    public void calculateTotalPrice() {
        double totalPrice = 0;
        double price = 0;
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).getProduct() + "\t\t");
            System.out.print(items.get(i).getQuantity() + "\t\t");
            System.out.print(items.get(i).getPrice() + "\t\t");
            price = items.get(i).getQuantity() * items.get(i).getPrice();
            System.out.println(price);
            totalPrice += items.get(i).getQuantity() * items.get(i).getPrice();
        }
        System.out.println("Összesen: \t\t" + totalPrice);
    }
}
