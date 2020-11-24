package schoolrecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        // program
        return false;
    }

    public static void main(String[] args) {
        Tutor tutor = new Tutor("Nagy Csilla",Arrays.asList(new Subject("vhjhjk"),
                                                                  new Subject("vhjhjk"),
                                                                  new Subject("vhjhjk")));

    }
}
