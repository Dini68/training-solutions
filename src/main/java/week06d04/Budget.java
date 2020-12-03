package week06d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItemsByMonth (int givenmonth){
        List<Item> filterItems = new ArrayList<>();
        for (Item it: items) {
            if (it.getMonth() == givenmonth) {
                filterItems.add(it);
            }
        }
        return filterItems;
    }

    public void toString(List<Item> filterItems) {
        for (Item it: filterItems) {
            System.out.println(it.getMonth() + " " + it.getName() + " " + it.getPrice());
        }
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1000, 1,"wine"),
                new Item(2000, 2,"champagne"),
                new Item(3000, 3,"chair"),
                new Item(4000, 4,"table"),
                new Item(5000, 5,"shoe"),
                new Item(6000, 6,"shirt"),
                new Item(7000, 7,"cat"),
                new Item(8000, 8,"jacket"),
                new Item(9000, 9,"diaper"),
                new Item(10000, 10,"beefsteak"),
                new Item(11000, 11,"motor oil"),
                new Item(12000, 12,"Risk"));
        Budget budget = new Budget(items);

        budget.toString(budget.getItemsByMonth(12));
    }
}
