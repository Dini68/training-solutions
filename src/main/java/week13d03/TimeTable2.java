package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.Arrays.sort;

public class TimeTable2 {

    private List<Subject> subjects = new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    private String validTeacherName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Teacher name is missing");
        }
        return name;
    }

    private String validSubjectName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Subject name is missing");
        }
        return name;
    }

    private String validClassName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Class name is missing");
        }
        return name;
    }

    private int validTeachingHours(String hours) {
        try {
            return Integer.parseInt(hours);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Teaching hours not number" + hours, nfe);
        }
    }

    private Subject createSubject(String[] lines) {
        String teacherName = validTeacherName(lines[0]);
        String subjectName = validSubjectName(lines[1]);
        String className = validClassName(lines[2]);
        int teachingHours = validTeachingHours(lines[3]);
        return new Subject(teacherName, subjectName, className, teachingHours);
    }

    private void isValidSubjects(int index) {
        if (subjects.size() == 0) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (index != 0) {
            throw new IllegalArgumentException("Missing data.");
        }

    }

    private void addSubjects(BufferedReader br) throws IOException {
        String[] lines = new String[4];
        int index = 0;
        while ((lines[index] = br.readLine()) != null) {
            if (index == 3) {
                subjects.add(createSubject(lines));
            }
            index = (index + 1) % 4;
        }
        isValidSubjects(index);
    }

    public void readTimeTableFromFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            addSubjects(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }

    }

    public int sumTeachingHoursPerWeekOfTeacher (String teacherName) {
        int sumHours = 0;
        boolean isFoundName = false;
        for (Subject sb: subjects) {
            if (sb.getTeacherName().equals(teacherName)) {
                sumHours += sb.getTeachingHours();
                isFoundName = true;
            }
        }
        if (isFoundName) return sumHours;
        throw new IllegalArgumentException("No such teacher name: " + teacherName);
    }

    public List<String> teachers() {
        List<String> teachers = new ArrayList<>();
        for(Subject sb: subjects) {
            if (!(teachers.contains(sb.getTeacherName()))) {
                teachers.add(sb.getTeacherName());
            }
        }
        return teachers;
    }

    public static void main(String[] args) {
        TimeTable2 timeTable2 = new TimeTable2();
        timeTable2.readTimeTableFromFile("beosztas.txt");
        System.out.println(timeTable2.sumTeachingHoursPerWeekOfTeacher("Medve Melani"));
        System.out.println(timeTable2.sumTeachingHoursPerWeekOfTeacher("Antilop Anett"));
        System.out.println(timeTable2.teachers().size());
        for (int i = 0; i < timeTable2.teachers().size(); i++) {
            System.out.println(timeTable2.teachers().get(i));
        }
    }
}
