package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGradesTest() {
        GradeRounder gradeRounder = new GradeRounder();
        int [] arr = {13, 68, 72, 42, 38, 84, 99, 43};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(gradeRounder.roundGrades(arr)));
        assertEquals(13, gradeRounder.roundGrades(arr)[0]);
        assertEquals(72, gradeRounder.roundGrades(arr)[2]);
        assertEquals(38, gradeRounder.roundGrades(arr)[4]);
        assertEquals(100, gradeRounder.roundGrades(arr)[6]);
        assertEquals(45, gradeRounder.roundGrades(arr)[7]);
    }
}