package week07d05.senior;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLine() {
        List<String> lines = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            System.out.println("Kérem az " + i + ". sort!");
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    private Path readFilename() {
        System.out.println("Kérem a fálnevet: ");
        String filename = scanner.nextLine();
        Path path = Path.of(filename);
        return path;
    }

    public void write(Path path, List<String> lines) {
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot writed file", ioe);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLine();
        Path path = saveInput.readFilename();
        saveInput.write(path, lines);

    }
}
