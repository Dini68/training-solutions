package week13d03;

public class Subject {

    private String teacherName;

    private String subjectName;

    private String className;

    private int teachingHours;

    public Subject(String teacherName, String subjectName, String className, int teachingHours) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.teachingHours = teachingHours;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "teacherName='" + teacherName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", className='" + className + '\'' +
                ", teachingHours=" + teachingHours +
                '}';
    }
}
//        Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
//        Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten. (edited)
