package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisors() {

        assertEquals(0, new DivisorFinder().findDivisors(0));
        assertEquals(2, new DivisorFinder().findDivisors(138));
        assertEquals(3, new DivisorFinder().findDivisors(54260));
        assertEquals(4, new DivisorFinder().findDivisors(10111));
    }
}