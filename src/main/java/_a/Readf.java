package _a;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Readf {

    public void readFromFile(String fileName) {
        Path file = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

}
