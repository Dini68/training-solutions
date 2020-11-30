package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        return str.equals("") || str.equals(null);
    }

    public boolean addStudent(Student student) {
        boolean isExists = false;
        for (Student st: students
             ) {
            if (st.getName().equals(student.getName())) {
                isExists = true;
                break;
            }
        }
        if (!isExists) students.add(student);
        return !isExists;
    } // felvesz egy diákot az osztályba

    public boolean removeStudent(Student student) {

        boolean isExists = false;
        for (Student st: students
        ) {
            if (st.getName().equals(student.getName())) {
                isExists = true;
                students.remove(st);
                break;
            }
        }
        return isExists;
    }//kivesz egy diákot az osztályból

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        for (Student st: students
             ) {
            if (st.getMarks().size() == 0 || st.getMarks() == null) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }

        double sum = 0;
        double count = 0;
        for (Student st: students
        ) {
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
        for (Student st: students
        ) {
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

        if ((students.size() == 0) || (students == null)) {
            throw new IllegalStateException("No students to search!");
        }

        boolean isExisting = false;
        for (Student st: students
             ) {
            if (st.getName().equals(name)) {
                isExisting = true;
                return st;
            }
        }
        if (!isExisting) {
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return null;
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
        String listStudents ="";
        for (Student st: students
             ) {
            if (!listStudents.equals("")) {
                listStudents += ", ";
            }
            listStudents += st.getName();

        }
        return listStudents;
    }//kilistázza a diákok neveit, vesszővel elválasztva

}
