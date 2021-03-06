package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private final String className;
    private final Random rnd;
    private final List<Student> students;

    {
        students = new ArrayList<>();
    }

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Az osztálynév nincs megadva!");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        return (str == null) || str.equals("");
    }

    public boolean addStudent(Student student) {
        boolean isExists = false;
        int i = 0;
        while (!isExists && (i < students.size())) {
            isExists = students.get(i).getName().equals(student.getName());
            i++;
        }
        if (!isExists) students.add(student);
        return !isExists;
    } // felvesz egy diákot az osztályba

    public boolean removeStudent(Student student) {
        boolean isExists = false;
        int i = 0;
        while (!isExists && (i < students.size())) {
            isExists = students.get(i).getName().equals(student.getName());
            i++;
        }
        if (isExists) students.remove(student);
        return isExists;
    }//kivesz egy diákot az osztályból

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        for (Student st: students) {
            if ((st.getMarks() == null) || (st.getMarks().size() == 0)) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        double sum = 0;
        double count = 0;
        for (Student st: students) {
            for (Mark m: st.getMarks()
                 ) {
                if (m != null) {
                    count++;
                    sum += m.getMarkType().getValue();
                }
            }
        }
        return Math.round(100 * sum / count) / 100.0;
    }//osztályátlagot számol, minden diákot figyelembe véve

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0;
        double count = 0;
        for (Student st: students) {
            for (Mark m: st.getMarks()
            ) {
                if ((m != null) && (m.getSubject().getSubjectName().equals(subject.getSubjectName()))) {
                    count++;
                    sum += m.getMarkType().getValue();
                }
            }
        }
        return Math.round(100 * sum / count) / 100.0;
    }//tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if ((students == null) || (students.size() == 0)) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student st: students) {
            if (st.getName().equals(name)) {
                return st;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }// név szerint megkeres egy diákot az osztályban

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }

        return students.get(rnd.nextInt(students.size()));
    }//felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student st: students
             ) {
            studyResultByNames.add(new StudyResultByName(st.calculateAverage(), st.getName()));
        }
        return studyResultByNames;
    }//a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames() {
        StringBuilder listStudents = new StringBuilder();
        for (Student st: students) {
            if (!listStudents.toString().equals("")) {
                listStudents.append(", ");
            }
            listStudents.append(st.getName());
        }
        return listStudents.toString();
    }//kilistázza a diákok neveit, vesszővel elválasztva
}
