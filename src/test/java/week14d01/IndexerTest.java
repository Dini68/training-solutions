package week14d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    void index() {
        Map<Character, List<String>> expected = Map.of('J', Arrays.asList("John", "Jack"),
                'L', Arrays.asList("Lujza"), 'M', Arrays.asList("Magdolna"));
        Indexer ind  = new Indexer();
        assertEquals(expected,ind. index(Arrays.asList("John", "Lujza", "Magdolna", "Jack")));

    }
}