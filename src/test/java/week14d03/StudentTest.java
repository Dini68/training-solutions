package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createTest() {
        Student s = new Student("John");

        assertEquals("John", s.getName());
        assertEquals(0, s.getMarks().size());
    }

    @Test
    public void addNoteTest() {
        Student s = new Student("John");

        s.addMark("math", 5);

        assertEquals(1, s.getMarks().size());
        assertEquals(5, s.getMarks().get("math").get(0));

        s.addMark("math", 4);
        assertEquals(2, s.getMarks().get("math").size());

        s.addMark("biology", 4);
        assertEquals(2, s.getMarks().size());
        assertEquals(4, s.getMarks().get("biology").get(0));


    }
}