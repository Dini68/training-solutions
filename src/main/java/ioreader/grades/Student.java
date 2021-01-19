package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name ;

    private List<Integer> gradeList = new ArrayList<>();

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.gradeList = marks;
    }

    public List<Integer> getGradeList() {

        return new ArrayList<>(gradeList);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(gradeList);
    }

    public double average() {
        double average;
        double sum = 0;
        for (int i = 0; i < gradeList.size(); i++) {
            sum += gradeList.get(i);
        }
        average = Math.round(sum * 1000 / gradeList.size()) / 1000.0;
        return average;
    }

    public boolean isIncreasing() {
        boolean increase = false;
        double sum = 0;
        double average;
        for (int i = 0; i < gradeList.size() - 1; i++) {
            sum += gradeList.get(i);
        }
        average = Math.round(sum * 1000 / (gradeList.size() - 1)) / 1000.0;
        if (gradeList.get(gradeList.size() - 1) > average()) {
            return true;
        }
        return increase;
    }
}
