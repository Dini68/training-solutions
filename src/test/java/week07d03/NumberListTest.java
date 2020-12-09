package week07d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumberListTest {

    @Test
    public void isIncreasingTest() {

    NumberList numbers = new NumberList();

    assertEquals(true, numbers.isIncreasing(Arrays.asList(1,2,4,5,8)));
    assertEquals(true, numbers.isIncreasing(Arrays.asList(-100,1,1,1,2,4,5,8)));
    assertEquals(true, numbers.isIncreasing(Arrays.asList(1,1,1,1,1,1)));
    assertEquals(false, numbers.isIncreasing(Arrays.asList(-1,2,4,-5,8)));
    }
}
