package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String str) {
        return false;
    }

    public void grading(Mark mark) {

    }// érdemjegy rögzítése

    public double calculateAverage() {
        return 1;
    }// teljes átlag számolása

    public double calculateSubjectAverage(Subject subject) {
        return 1;
    }// tantárgyhoz tartozó átlag számítása

    public String toString() {
        return "";
    } // diák szöveges reprezentációja
}

