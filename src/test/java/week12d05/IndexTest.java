package week12d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexTest {

    @Test
    void sumStringFromIndex() {
        Index in = new Index();
        assertEquals(11, in.sumStringFromIndex());
    }
}