package week11d03.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    CharCounter cc = new CharCounter();

    @Test
    void countCharsTest() {
        assertEquals(2,cc.countChars(new String[] {"abc", "cba", "ab"}));
        assertEquals(3,cc.countChars(new String[] {"abc", "cba", "abcdf"}));
        assertEquals(2,cc.countChars(new String[] {"abcwer", "cba", "aab"}));
        assertEquals(3,cc.countChars(new String[] {"abc"}));
        assertEquals(0,cc.countChars(new String[] {"abc", "ser3"}));
        assertEquals(0,cc.countChars(new String[] {""}));
    }
    @Test
    void countCharsWithNullTest() {
        assertThrows(IllegalArgumentException.class, () -> cc.countChars(null));
        assertThrows(IllegalArgumentException.class, () -> cc.countChars(new String[] {}));
    }

}