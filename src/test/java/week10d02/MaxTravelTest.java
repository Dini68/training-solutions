package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        assertEquals(Arrays.asList(4, 12), new MaxTravel(Arrays.asList(12, 12, 0, 3, 4, 4)).getMaxIndex());
        assertEquals(Arrays.asList(12), new MaxTravel(Arrays.asList(12, 12, 0, 3, 4, 4, 12)).getMaxIndex());
        assertEquals(Arrays.asList(4), new MaxTravel(Arrays.asList(12, 12, 0, 3, 4, 4, 4)).getMaxIndex());
        assertEquals(Arrays.asList(0, 4, 12), new MaxTravel(Arrays.asList(12, 12, 0, 0, 3, 4, 4)).getMaxIndex());
    }
    @Test
    void testMaxTravelCreate () {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravel(Arrays.asList(12,31)));
    }
}