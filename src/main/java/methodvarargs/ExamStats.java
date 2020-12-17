package methodvarargs;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int goodResult = 0;
        for (int i = 0; i < results.length; i++) {
            if (results[i] >= maxPoints * limitInPercent / 100.0) {
                goodResult ++;
            }
        }
        return goodResult;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        boolean hasAnyFailed = false;
        for (int i = 0; i < results.length; i++) {
            if (results[i] < maxPoints * limitInPercent / 100.0) {
                hasAnyFailed = true;
            }
        }
        return hasAnyFailed;
    }
}
