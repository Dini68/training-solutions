package week07d01;

import org.junit.jupiter.api.Test;
import week05d05.User;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    public void isPrimeTest() {
        assertEquals(false, new MathAlgorithms().isPrime(1));
        assertEquals(true, new MathAlgorithms().isPrime(2));
        assertEquals(true, new MathAlgorithms().isPrime(3));
        assertEquals(false, new MathAlgorithms().isPrime(4));
        assertEquals(true, new MathAlgorithms().isPrime(5));
        assertEquals(true, new MathAlgorithms().isPrime(23));
        assertEquals(false, new MathAlgorithms().isPrime(32));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().isPrime(-2));
        assertEquals("Nem lehet 1-nél kisebb a paraméter!", ex.getMessage());
    }

}
