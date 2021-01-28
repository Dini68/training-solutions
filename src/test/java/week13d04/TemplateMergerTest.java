package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void mergeTest() {
        TemplateMerger tm = new TemplateMerger();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 2000));
        employees.add(new Employee("Jack Doe", 1990));
        String result = tm.merge(Path.of("format.txt"), employees);
        assertEquals("Az alkalmazott neve: John Doe, születési éve: 2000\n" +
                "Az alkalmazott neve: Jack Doe, születési éve: 1990\n", result);
    }
}