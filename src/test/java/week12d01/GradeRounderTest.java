package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGradesTest() {
        GradeRounder gradeRounder = new GradeRounder();
        int [] arrParam = {13, 68, 72, 42, 38, 84, 99, 43};
        int [] arrResult = {13, 70, 72, 42, 38, 85, 100, 45};
        assertArrayEquals(arrResult, gradeRounder.roundGrades(arrParam));
    }
}