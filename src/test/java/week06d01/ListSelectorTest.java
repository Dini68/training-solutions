package week06d01;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import schoolrecords.ClassRecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ListSelectorTest {

    @Test
    public void emptylistSelectorTest() {
        List<String> emptyList = new ArrayList<>();
        ListSelector listSelector = new ListSelector();
        assertEquals("", listSelector.listSelector(emptyList));
    }

    @Test
    public void listSelectorTest() {
        ListSelector listSelector = new ListSelector();
        List<String> originalList = Arrays.asList(
                "alma",
                "körte",
                "szilva",
                "barack",
                "banán",
                "eper",
                "citrom");
        assertEquals("[alma,szilva,banán,citrom]",
                listSelector.listSelector(originalList));
    }

}