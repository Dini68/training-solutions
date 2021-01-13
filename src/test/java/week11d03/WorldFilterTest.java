package week11d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldFilterTest {

    WorldFilter wf = new WorldFilter();

    @Test
    void wordsWithCharTest() {
        List<String> testList = Arrays.asList("break", "yes", "black", "mind");
        assertEquals(Arrays.asList("break", "black"), wf.wordsWithChar(testList, 'k'));
        assertEquals(Arrays.asList("break", "yes"), wf.wordsWithChar(testList, 'e'));
        assertEquals(Arrays.asList("mind"), wf.wordsWithChar(testList, 'm'));
        assertEquals(new ArrayList<>(), wf.wordsWithChar(testList, 'o'));
    }

    @Test
    void wordsWithCharWithNullTest() {
        assertThrows(IllegalArgumentException.class, () -> wf.wordsWithChar(null, 'j'));
    }
}