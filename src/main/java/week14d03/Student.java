package week14d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Student {

    private String name;

    private Map<String, List<Integer>> marks = new TreeMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void addMark(String subject, int mark) {
        List<Integer> temp = new ArrayList<>();
        if (marks.containsKey(subject)) {
            temp = marks.get(subject);
            temp.add(mark);
            marks.put(subject, temp);
        }
        else {
            temp.add(mark);
            marks.put(subject, temp);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}'+"\n";
    }
}
