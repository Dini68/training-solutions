package week11d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @Test
    void sumNumberTest() {
        FilesSum filesSum = new FilesSum();
        assertEquals(80, filesSum.sumNumbers());
    }
}