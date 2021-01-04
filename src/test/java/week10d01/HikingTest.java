package week10d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevation() {
        Hiking hiking = new Hiking();
        assertEquals(13.0, hiking.getPlusElevation(List.of(10.0,20.0,15.0,18.0)));
        assertEquals(0.0, hiking.getPlusElevation(List.of(10.0,10.0,10.0)));
        assertEquals(0.0, hiking.getPlusElevation(List.of(10.0)));
    }
    @Test
    void getPlusElevationWithEmpty() {
        Hiking hiking = new Hiking();
        assertThrows(IllegalArgumentException.class, () -> hiking.getPlusElevation(List.of()));
        assertThrows(IllegalArgumentException.class, () -> hiking.getPlusElevation(null));
    }

}