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
    void getElevation() {
        HikingFile hf = new HikingFile();
        Path path = Path.of("src/main/java/week10d01/senior/gps.txt");
        try (InputStream is = new FileInputStream(String.valueOf(path))){
            ElevationDate ev = hf.getElevation(is);
            assertEquals(170, ev.getIncrease());
            assertEquals(160, ev.getDecrease());
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file", ioException);
        }
    }
}