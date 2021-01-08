package week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void findMinSum() {
        assertEquals(13,(new Calculator().findMinSum(new int[]{14,10,3,5,7,0,5,8,9})));
        assertEquals(-8,(new Calculator().findMinSum(new int[]{0,0,0,0,0,-8,0})));
        assertEquals(19,(new Calculator().findMinSum(new int[]{4,10,3,5,7,9})));
        assertEquals(44,(new Calculator().findMinSum(new int[]{14,10,14,10,14,10,14})));
    }
}