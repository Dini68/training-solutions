package stringscanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringScannerTest {

    StringScanner stringScanner = new StringScanner();

    @Test
    public void readAndSumValuesTest() {
        assertEquals(150, stringScanner.readAndSumValues("10 20 30 40 50"));
    }
    @Test
    public void readAndSumValuesWithDelimiterTest() {
        assertEquals(150, stringScanner.readAndSumValues("10,20,30,40,50", ","));
    }
    @Test
    public void filterLinesWithWordOccurrencesTest() {
        assertEquals("Az alma gyümölcs.", stringScanner.filterLinesWithWordOccurrences("Az alma gyümölcs.\nA répa zöldség.","alma"));
    }
    @Test
    public void readAndSumValuesWithDelimiterWithEmptyStringTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> stringScanner.readAndSumValues(""));
        Assertions.assertEquals("Üres, vagy null paraméter!", ex.getMessage());
    }
    @Test
    public void readAndSumValuesWithDelimiterWithNullStringTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> stringScanner.readAndSumValues(null));
        Assertions.assertEquals("Üres, vagy null paraméter!", ex.getMessage());
    }
    @Test
    public void filterLinesWithWordOccurrencesWithEmptyStringTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> stringScanner.filterLinesWithWordOccurrences("", ""));
        Assertions.assertEquals("Üres, vagy null paraméter!", ex.getMessage());
    }
    @Test
    public void filterLinesWithWordOccurrencesWithNullStringTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> stringScanner.filterLinesWithWordOccurrences(null,null));
        Assertions.assertEquals("Üres, vagy null paraméter!", ex.getMessage());
    }


}
