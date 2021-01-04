package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListCounterTest {


    @Test
    public void listCounterTest () {
        ListCounter listCounter = new ListCounter();
        List<String> testList = new ArrayList<>();
        testList.add("Asztal");
        testList.add("malom");
        testList.add("atom");
        testList.add("akkor");

        testList.add("barack");
        testList.add("Abrak");
        testList.add("Asztal");
        testList.add("a");

        assertEquals(6, listCounter.listCounter(testList));
    }

    @Test
    public void testNullAndEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> new ListCounter().listCounter(null));
        assertThrows(IllegalArgumentException.class, () -> new ListCounter().listCounter(new ArrayList<>()));
    }

}
