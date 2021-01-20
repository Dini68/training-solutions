package week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void minNumber1X() {
        NumberStat numberStat = new NumberStat();
        numberStat.numbersReadFromFile("numbers.txt");
        assertEquals(4,numberStat.minNumber1X());
    }
}