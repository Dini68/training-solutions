package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        testList.add("másik");
        testList.add("a");

        assertEquals(5, listCounter.listCounter(testList));
    }

}
