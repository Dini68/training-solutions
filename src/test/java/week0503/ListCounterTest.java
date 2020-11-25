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
    public void test() {
        assertEquals(5,
                new ListCounter().listCounter(Arrays.asList("Aghj", "alma", "hjkh", "arom", "a", "Atom")));
        assertEquals(0,
                new ListCounter().listCounter(Arrays.asList()));
        assertEquals(0,
                new ListCounter().listCounter(Arrays.asList("sdakhggh", "jhkkjj")));
    }
}


