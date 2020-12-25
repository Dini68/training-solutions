package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibCalculatorWithBinetFormulaTest {
    @Test
    public void sumEvensTest() {
        FibCalculatorWithBinetFormula fibCalculator = new FibCalculatorWithBinetFormula();
        assertEquals(0, fibCalculator.sumEvens(0));
        assertEquals(0, fibCalculator.sumEvens(1));
        assertEquals(0, fibCalculator.sumEvens(2));
        assertEquals(10, fibCalculator.sumEvens(15));
        assertEquals(10, fibCalculator.sumEvens(48));
        assertEquals(44, fibCalculator.sumEvens(55));
        assertEquals(60696, fibCalculator.sumEvens(190000));
    }

}
