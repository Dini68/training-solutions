package week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void sortNoteBookTest() {
        ClassNotebook cn = new ClassNotebook(new ArrayList<>(List.of(new Student("John"), new Student("Bill"),
                        new Student("Jane"))));

        List<Student> result = cn.sortNotebook();

        assertEquals("Bill", result.get(0).getName());
        assertEquals("John", result.get(2).getName());

        result.add(new Student("Jack"));
        assertEquals(3, cn.getStudents().size());

        result.get(0).addMark("math", 5);
        assertEquals(0, cn.getStudents().get(1).getMarks().size());

    }
}