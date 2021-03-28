package week10d01.senior;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void getElevation() throws FileNotFoundException {
        HikingFile hf = new HikingFile();
        ElevationDate ev = hf.getElevation(new FileInputStream("src/main/java/week10d01/senior/gps.txt"));
        assertEquals(170, ev.getIncrease());
        assertEquals(160, ev.getDecrease());
    }
}