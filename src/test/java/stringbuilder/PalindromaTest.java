package stringbuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PalindromaTest {
    Palindroma palindroma = new Palindroma();

    @Test
    public void textIsPalindromTest() {
        assertEquals(true, palindroma.isPalindrom("gézakékazég"));
    }
    @Test
    public void textWithSpaceIsPalindromTest() {
        assertEquals(false, palindroma.isPalindrom("géza kék az ég"));
    }
    @Test
    public void textWithUpperIsPalindromTest() {
        assertEquals(true, palindroma.isPalindrom("Indulagörögaludni"));
    }
    @Test
    public void textWithNullIsPalindromTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> palindroma.isPalindrom(null));
        Assertions.assertEquals("Null a paraméter!", ex.getMessage());
    }

}
