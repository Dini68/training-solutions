package week13d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityFinderTest {

    @Test
    void longestNamedCity() {
        CityFinder cf = new CityFinder();
        assertEquals("Jászfelsőszentgyörgy",cf.longestNamedCityFromFile("src/main/resources/iranyitoszamok-varosok.csv"));
        assertEquals(3324,cf.getCities().size());
    }
}