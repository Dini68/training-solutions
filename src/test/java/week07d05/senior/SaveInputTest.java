package week07d05.senior;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SaveInputTest {

    @TempDir
    Path tempDirectory;

    @Test
    public void testReadLines() {
        Scanner scanner = new Scanner("aaa\nbbb\nccc");
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLine();

        assertEquals(List.of("aaa", "bbb", "ccc"), lines);
    }
    @Test
    public void testWrite() throws IOException {
        SaveInput saveInput = new SaveInput(new Scanner(System.in));

        Path file = tempDirectory.resolve("test.txt");
        saveInput.write(file, List.of("alma", "korte"));

        String result = Files.readString(file);
        assertEquals("alma\r\nkorte\r\n", result);
    }


}