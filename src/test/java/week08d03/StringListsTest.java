package week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringListsTest {

    @Test
    public void stringListsUnionTest() {
        StringLists sL = new StringLists();
        assertEquals(Arrays.asList("a","b","c","e","d","f"),sL.stringListsUnion(Arrays.asList("a", "b", "c", "e"),
                     Arrays.asList("a","d","f","e")));
    }
}
