package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DigitSumTest {

    @Test
    public void sumOfDigitsTest() {
        assertEquals(17, new DigitSum().sumOfDigits(-12356));
        assertEquals(0, new DigitSum().sumOfDigits(0));
        assertEquals(10, new DigitSum().sumOfDigits(1234));
    }
}
