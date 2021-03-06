package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    private boolean isEmpty(String str) {
        return (str == null) || str.equals("");
    }


    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }// érdemjegy rögzítése

    public double calculateAverage() {
        double average = 0.0;
        double sum = 0;
        double count = 0;
        for (Mark m: marks
             ) {
            count++;
            sum += m.getMarkType().getValue();
        }
        if (count > 0.5) {
            average = Math.round(sum * 100 / count) / 100.0;
        }
        return average;
    }// teljes átlag számolása

    public double calculateSubjectAverage(Subject subject) {
        double average = 0.0;
        double sum = 0;
        double count = 0;
        for (Mark m: marks
        ) {
            if (m.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                count++;
                sum += m.getMarkType().getValue();
            }
        }
        if (count > 0.5) {
            average = Math.round(sum * 100 / count) / 100.0;
        }
        return average;
    }// tantárgyhoz tartozó átlag számítása

    public String toString() {
        String s = "";
        int j = 0;
        for (Mark m: marks) {
            if (j > 0) {
                s = s + "\n";
            }
            j++;
            s = s + getName() + " marks: " + m.getSubject().getSubjectName() + ": " + m.toString();
        }
        return s;
    } // diák szöveges reprezentációja

}

