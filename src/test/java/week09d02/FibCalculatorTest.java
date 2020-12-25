package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibCalculatorTest {

    @Test
    public void sumEvensTest() {
        FibCalculator fibCalculator = new FibCalculator();
        assertEquals(0, fibCalculator.sumEvens(0));
        assertEquals(0, fibCalculator.sumEvens(1));
        assertEquals(2, fibCalculator.sumEvens(2));
        assertEquals(10, fibCalculator.sumEvens(15));
        assertEquals(44, fibCalculator.sumEvens(48));
    }
}
