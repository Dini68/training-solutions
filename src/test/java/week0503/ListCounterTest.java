package week0503;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;
import week05d03.ListCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListCounterTest {

    @Test
    public void startWithATest() {
        assertEquals(5,
                new ListCounter().listCounter(Arrays.asList("Aghj", "alma", "hjkh", "arom", "a", "Atom")));
    }
    @Test
    public void startWithEmptyListTest() {
        assertEquals(0,
                new ListCounter().listCounter(Arrays.asList()));
    }

    @Test
    public void startWithANonListTest() {
        assertEquals(0,
                new ListCounter().listCounter(Arrays.asList("sdakhggh", "jhkkjj")));
    }
}


