package week06d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

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
            new Item(10000, 11,"beefsteak"),
            new Item(11000, 11,"motor oil"),
            new Item(12000, 12,"Risk"));
    Budget budget = new Budget(items);

    @Test
    public void getItemsByMonthTest () {
        assertEquals("cat", budget.getItemsByMonth(7).get(0).getName());
        assertEquals(7000, budget.getItemsByMonth(7).get(0).getPrice());
        assertEquals("motor oil", budget.getItemsByMonth(11).get(1).getName());
        assertEquals(11000, budget.getItemsByMonth(11).get(1).getPrice());
    }
}
