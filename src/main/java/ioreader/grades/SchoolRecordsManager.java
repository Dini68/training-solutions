package ioreader.grades;

import ioreader.states.State;
import schoolrecords.Mark;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/"+fileName))){
            String line;
            String studentName;
            String marksString;
            int markValue;
            while ((line = reader.readLine()) != null) {
                List<Integer> marks = new ArrayList<>();
                studentName = line.substring(0, line.indexOf(' '));
                marksString = line.substring(line.indexOf(' ') + 1);
                for (int i = 0; i < marksString.length(); i+=2) {
                    markValue = Integer.parseInt(marksString.substring(i, i+1));
                    marks.add(markValue);
                }
                students.add(new Student(studentName, marks));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }

    }

    public double classAverage() {
        double average;
        int count = 0;
        int sum = 0;
        for (Student st: students) {
            for (int mark: st.getMarks()) {
                count++;
                sum += mark;
            }
        }
        average = Math.round(sum * 1000.0 / count) / 1000.0;
        return average;
    }

}
