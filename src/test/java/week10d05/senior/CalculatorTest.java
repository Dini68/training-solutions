package week10d05.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void findMinSumTest() {
        assertEquals(16,new Calculator().findMinSum(new int[]{1,3,5,7,9}));
        assertEquals(13,new Calculator().findMinSum(new int[]{14,10,3,5,7,0,5,8,9}));
        assertEquals(0,new Calculator().findMinSum(new int[]{0,0,0,0,0,0,0}));
        assertEquals(19,new Calculator().findMinSum(new int[]{4,10,3,5,7,9}));
        assertEquals(44,new Calculator().findMinSum(new int[]{14,10,14,10,14,10,14}));
    }

    @Test
    void findMaxSumTest() {
        assertEquals(24,new Calculator().findMaxSum(new int[]{1,3,5,7,9}));
        assertEquals(41,new Calculator().findMaxSum(new int[]{14,10,3,5,7,0,5,8,9}));
        assertEquals(0,new Calculator().findMaxSum(new int[]{0,0,0,0,0,0,0}));
        assertEquals(31,new Calculator().findMaxSum(new int[]{4,10,3,5,7,9}));
        assertEquals(56,new Calculator().findMaxSum(new int[]{14,10,14,10,14,10,14}));
    }

    @Test
    void findMinMaxSumTest() {
        assertEquals("16 24",new Calculator().findMinMaxSum(new int[]{1,3,5,7,9}));
        assertEquals("13 41",new Calculator().findMinMaxSum(new int[]{14,10,3,5,7,0,5,8,9}));
        assertEquals("0 0",new Calculator().findMinMaxSum(new int[]{0,0,0,0,0,0,0}));
        assertEquals("19 31",new Calculator().findMinMaxSum(new int[]{4,10,3,5,7,9}));
        assertEquals("44 56",new Calculator().findMinMaxSum(new int[]{14,10,14,10,14,10,14}));
    }
}