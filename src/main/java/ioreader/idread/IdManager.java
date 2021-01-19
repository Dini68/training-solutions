package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> ids = new ArrayList<>();

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

    public void readIdsFromFile(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/" + file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }
}
