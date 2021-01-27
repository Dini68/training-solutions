package week13d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTable2Test {

    @Test
    void sumTeachingHoursPerWeekOfTeacherTest() {
        TimeTable2 timeTable2 = new TimeTable2();
        timeTable2.readTimeTableFromFile("beosztas.txt");
        assertEquals(23, timeTable2.sumTeachingHoursPerWeekOfTeacher("Medve Melani"));
        assertEquals(25, timeTable2.sumTeachingHoursPerWeekOfTeacher("Antilop Anett"));
    }
}