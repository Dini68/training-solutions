package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterCounterTest {
    @Test
    void numberOfDifferentLettersInWordTest() {
        LetterCounter lc = new LetterCounter();
        assertEquals(5, lc.numberOfDifferentLettersInWord("Alma 112Ft"));
        assertEquals(8, lc.numberOfDifferentLettersInWord("Kereskedő-lánc"));
        assertEquals(1, lc.numberOfDifferentLettersInWord("15151,{a/*/"));

        assertThrows(IllegalArgumentException.class, () -> lc.numberOfDifferentLettersInWord(""));
        assertThrows(IllegalArgumentException.class, () -> lc.numberOfDifferentLettersInWord(null));
    }
}