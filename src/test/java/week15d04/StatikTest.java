package week15d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatikTest {

    @Test
    void max3CovidNumberPerWeekTest() {
        Statik ba = new Statik();
        ba.readFromFileToLines("src/main/java/week15d04/covid19.csv");
        assertEquals(39170, ba.max3CovidNumberPerWeek().get(0).getCaseNumber());
        assertEquals("2020-49", ba.max3CovidNumberPerWeek().get(1).getWeek());
    }
}