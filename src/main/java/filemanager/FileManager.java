package filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<Human> humans = new ArrayList<>();

    public void readFromFile() {
        List<String> names = new ArrayList<>();
        if (Files.isRegularFile(Path.of("humans.txt"))) {
            try {
                names = Files.readAllLines(Path.of("humans.txt"));
            } catch (IOException e) {
                throw new IllegalStateException("Can not read file", e);
            }
        }
        for (String name: names) {
            humans.add(new Human(name.substring(0, name.indexOf(" ")),name.substring(name.indexOf(" ") + 1, name.length())));
        }
        System.out.println(names);
        for (Human hu: humans) {
            System.out.println(hu.getLastName() + " " + hu.getFirstName());
        }
    }

    public static void main(String[] args) {
        new FileManager().readFromFile();
    }
}
