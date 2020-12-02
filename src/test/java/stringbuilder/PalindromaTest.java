package stringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PalindromaTest {

    @Test
    public void textIsPalindromTest() {
        Palindroma palindroma = new Palindroma();
        assertEquals(true, palindroma.isPalindrom("gézakékazég"));
        assertEquals(true, palindroma.isPalindrom("indulagörögaludni"));
        assertEquals(true, palindroma.isPalindrom("Indulagörögaludni"));
    }
    @Test
    public void textWithSpaceIsPalindromTest() {
        Palindroma palindroma = new Palindroma();
        assertEquals(false, palindroma.isPalindrom("géza kék az ég"));
    }
    @Test
    public void textwithUpperIsPalindromTest() {
        Palindroma palindroma = new Palindroma();
        assertEquals(true, palindroma.isPalindrom("Indulagörögaludni"));
    }
}
