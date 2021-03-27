package week08d02.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    @Test
    public void testReadFromFile() {
        CountryStatistics cs = new CountryStatistics();
        cs.readFromFile();
        assertEquals(11, cs.getCountries().size());
    }
    @Test
    public void testMaxPopulation() {
        CountryStatistics cs = new CountryStatistics();
        cs.readFromFile();
        assertEquals("Kongoi_Demokratikus_Koztarsasag", cs.maxPopulation().getName());
    }

}