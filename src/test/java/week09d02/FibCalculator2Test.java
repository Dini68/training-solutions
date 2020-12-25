package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibCalculator2Test {

    @Test
    public void sumEvensTest() {
        FibCalculator2 fibCalculator2 = new FibCalculator2();
        assertEquals(0, fibCalculator2.sumEvens(0));
        assertEquals(0, fibCalculator2.sumEvens(1));
        assertEquals(0, fibCalculator2.sumEvens(2));
        assertEquals(10, fibCalculator2.sumEvens(15));
        assertEquals(10, fibCalculator2.sumEvens(48));
        assertEquals(44, fibCalculator2.sumEvens(55));
    }

}
