package week13d03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class TimeTable2 {

    private final List<Subject> subjects = new ArrayList<>();

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
        Collections.sort(teachers);
        return teachers;
    }

    public List<String> subjectList() {
        List<String> subjectList = new ArrayList<>();
        for(Subject sb: subjects) {
            if (!(subjectList.contains(sb.getSubjectName()))) {
                subjectList.add(sb.getSubjectName());
            }
        }
        Collections.sort(subjectList);
        return subjectList;
    }

    public List<String> classList() {
        List<String> classList = new ArrayList<>();
        for(Subject sb: subjects) {
            if (!(classList.contains(sb.getClassName()))) {
                classList.add(sb.getClassName());
            }
        }
        Collections.sort(classList);
        return classList;
    }

    public void writeSchoolToFile(String filename, List<String> result) {
        List<String> schoolList = result;
        Path path = Path.of(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (String s: schoolList) {
                writer.write(s + "\n");
            }

        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }
    }


    public static void main(String[] args) {
        TimeTable2 timeTable2 = new TimeTable2();
        timeTable2.readTimeTableFromFile("beosztas.txt");
        System.out.println(timeTable2.sumTeachingHoursPerWeekOfTeacher("Medve Melani"));
        System.out.println(timeTable2.sumTeachingHoursPerWeekOfTeacher("Antilop Anett"));
        List<String> schoolList = new ArrayList<>();
        List<String> teachers = timeTable2.teachers();
        System.out.println("    Tanárok száma: " + teachers.size());
        schoolList.add("    Tanárok száma: " + teachers.size());
        for (String teacher : teachers) {
            schoolList.add(teacher);
            System.out.println(teacher);
        }
        List<String> subjectList = timeTable2.subjectList();
        System.out.println("    Tantárgyak száma: " + subjectList.size());
        schoolList.add("    Tantárgyak száma: " + subjectList.size());
        for (String sub : subjectList) {
            schoolList.add(sub);
            System.out.println(sub);
        }
        List<String> classList = timeTable2.classList();
        System.out.println("    Osztályok száma: " + classList.size());
        schoolList.add("    Osztályok száma: " + classList.size());
        for (String cl : classList) {
            schoolList.add(cl);
            System.out.println(cl);
        }
        timeTable2.writeSchoolToFile("school.txt", schoolList);
    }
}
