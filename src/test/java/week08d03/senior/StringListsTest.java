package week08d03.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListsTest {

    @Test
    public void testShortestWords(){
        StringLists sl = new StringLists();
        List<String> result = sl.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd"));
        assertEquals(List.of("aa", "bb", "dd"), result);
    }
}