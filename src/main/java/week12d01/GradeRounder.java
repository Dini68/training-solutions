package week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int[] roundGrades = new int[grades.length];
        for(int i = 0; i < grades.length; i++) {
            if (grades[i] < 40 || grades[i] % 5 < 3) {
                roundGrades[i] = grades[i];
            }
            else {
                roundGrades[i] = ((grades[i] / 5) + 1) * 5;
            }
        }
        return roundGrades;
    }
}
