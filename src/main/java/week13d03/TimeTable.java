package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeTable {

    private List<Subject> subjects = new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    private void addSubjects(BufferedReader br) throws IOException {
        String teacherName = "";
        String subjectName = "";
        String className = "";
        int teachingHours;
        String line;
        int index = 0;
        while ((line = br.readLine()) != null) {
            if (index == 0) {
                teacherName = line;
            }
            if (index == 1) {
                subjectName = line;
            }
            if (index == 2) {
                className = line;
            }
            if (index == 3) {
                teachingHours = Integer.parseInt(line);
                subjects.add(new Subject(teacherName, subjectName, className, teachingHours));
            }
            index = (index + 1) % 4;
        }
        if (subjects.size() == 0) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (index != 0) {
            throw new IllegalArgumentException("Missing data.");
        }
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

    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();
        timeTable.readTimeTableFromFile("beosztas.txt");
        System.out.println(timeTable.sumTeachingHoursPerWeekOfTeacher("Medve Melani"));
        System.out.println(timeTable.sumTeachingHoursPerWeekOfTeacher("Antilop Anett"));
    }
}
//    Mai Junior/Mid-level feladat (`week13d03`):
//        Adott a következő szerkezetű fájl, beosztas.txt:
//        Albatrosz Aladin
//        biologia
//        9.a
//        2
//        Albatrosz Aladin
//        osztalyfonoki
//        9.a
//        1
//        Csincsilla Csilla
//        matematika
//        9.b
//        2
//        A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg.
//        Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
//        Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten. (edited)