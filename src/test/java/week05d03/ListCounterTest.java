package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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


