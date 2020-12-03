package algorithmsmax.salesperson;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HighestSellingSalespersonTest {

    List<Salesperson> salespeople = Arrays.asList(
            new Salesperson("Kovács Dénes",2_000_000,1_500_000),
            new Salesperson("Simon Ferenc",3_000_000,2_500_000),
            new Salesperson("Berta Attila",4_000_000,3_500_000),
            new Salesperson("Pál Zoltán",1_000_000,1_500_000));

    @Test
    public void highestSellingSalespersonTest() {
        assertEquals("Berta Attila", new HighestSellingSalesperson().highestSellingSalesperson(salespeople));
    }
}
