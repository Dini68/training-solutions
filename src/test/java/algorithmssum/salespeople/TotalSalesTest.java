package algorithmssum.salespeople;

import algorithmssum.salespeople.Salesperson;
import algorithmssum.salespeople.TotalSales;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TotalSalesTest {

    List<Salesperson> totalSales = Arrays.asList(
            new Salesperson("Kovács Dénes", 5_000_000),
            new Salesperson("Simon Tünde", 3_000_000),
            new Salesperson("Varga József", 4_000_000),
            new Salesperson("Nagy Miklós", 6_000_000));

    @Test
    public void sumTotalSalesTest() {
        assertEquals(18_000_000, new TotalSales().sumTotalSales(totalSales));
    }

    @Test
    public void emptyInNameTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                        new Salesperson("", 4_000_000));
        assertEquals("Nincs megadva név!", ex.getMessage());
    }
    @Test
    public void minusInAmountTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                        new Salesperson("Varga József", -4_000_000));
        assertEquals("Nem lehet negatív a bevétel!", ex.getMessage());
    }
}