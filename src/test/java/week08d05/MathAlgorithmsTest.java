package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MathAlgorithmsTest {

    @Test
    public void greatestCommonDivisorTest() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(2, mathAlgorithms.greatestCommonDivisor(4,6));
        assertEquals(3, mathAlgorithms.greatestCommonDivisor(9,6));
        assertEquals(6, mathAlgorithms.greatestCommonDivisor(12,6));
        assertEquals(6, mathAlgorithms.greatestCommonDivisor(6,6));
        assertEquals(1, mathAlgorithms.greatestCommonDivisor(11,6));
    }
}
