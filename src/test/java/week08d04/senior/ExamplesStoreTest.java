package week08d04.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    public void testGetTitlesOfExamples() {
        ExamplesStore es = new ExamplesStore();
        assertEquals(List.of("Első feladat", "Második feladat"), es.getTitlesOfExamples());
    }

}