package ioreader.grades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolRecordsManagerTest {

    private SchoolRecordsManager schoolRecordsManager = new SchoolRecordsManager();

    @Test
    public void readFromFileTe444st() {
        schoolRecordsManager.readGradesFromFile("grades.txt");

        assertEquals(4, schoolRecordsManager.getStudents().size());
        assertEquals(5, schoolRecordsManager.getStudents().get(3).getGradeList().get(0).longValue());
        assertEquals("Jason_Butler", schoolRecordsManager.getStudents().get(3).getName());
        assertEquals(4.0, schoolRecordsManager.getStudents().get(2).average(), 0.000001);

    }


    @Test
    public void classAverageTest() {
        schoolRecordsManager.readGradesFromFile("grades.txt");

        assertEquals(3.542, schoolRecordsManager.classAverage(), 0.001);
    }


}