package week14d03;

import java.util.*;

public class Student implements Comparable<Student>{

    private String name;

    private Map<String, List<Integer>> marks = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student s) {
        name = s.name;
        marks = new HashMap<>(s.marks);
    }

    public Map<String, List<Integer>> getMarks() {
        return new HashMap<>(marks);
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

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
