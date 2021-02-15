package week13d04.mid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try {
            StringBuilder sb = new StringBuilder();
            String line = Files.readString(file);
            for (Employee e: employees) {
                String replaced = line.replace("{nev}", e.getName());
                replaced = replaced.replace("{ev}", Integer.toString(e.getYearOfBirth()));
                sb.append(replaced).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/java/week13d04/mid/employee-template.txt");
        List<Employee> employees =
                List.of(
                        new Employee("John Doe",1990),
                        new Employee("Jack Doe",2000)
                );
        TemplateMerger tm = new TemplateMerger();
        String result = tm.merge(path, employees);
        System.out.println(result);
    }
}
