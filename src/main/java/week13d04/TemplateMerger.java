package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TemplateMerger {

    public String processList(String template, List<Employee> employees) {
        StringBuilder result = new StringBuilder();
        String line = "";
        for (Employee em: employees) {
            line = template.replace("{nev}", em.getName());
            line = line.replace("{ev}", Integer.toString(em.getYearOfBirth()));
            result.append(line + "\n");
        }
        return result.toString();
    }

    public String merge(Path file, List<Employee> employees){
        try {
            String template = Files.readString(file);
            return processList(template, employees);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        TemplateMerger tm = new TemplateMerger();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 2000));
        employees.add(new Employee("Jack Doe", 1990));
        System.out.println(tm.merge(Path.of("format.txt"), employees));
    }
}
