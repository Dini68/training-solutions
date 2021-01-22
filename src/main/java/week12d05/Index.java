package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Index {

    public int sumStringFromIndex() {
        int sum = 0;
        Path path = Path.of("Index.html");
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null) {
                if (line.contains("koronavírus")) {
                    sum ++;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return sum;
    }

    public static void main(String[] args) {
        Index index = new Index();
        System.out.println(index.sumStringFromIndex());
    }
}
