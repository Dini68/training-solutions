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
        return false;
    }

    public boolean addStudent(Student student) {
        return false;
    } // felvesz egy diákot az osztályba

    public boolean removeStudent(Student student) {
        return false;
    }//kivesz egy diákot az osztályból

    public double calculateClassAverage() {
        return 1;
    }//osztályátlagot számol, minden diákot figyelembe véve

    public double calculateClassAverageBySubject(Subject subject) {
        return 1;
    }//tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye

    public Student findStudentByName(String name) {
        return null;
    }// név szerint megkeres egy diákot az osztályban

    public Student repetition() {
        return null;
    }//felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults() {
        return null;
    }//a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames() {
        return "";
    }//kilistázza a diákok neveit, vesszővel elválasztva

}