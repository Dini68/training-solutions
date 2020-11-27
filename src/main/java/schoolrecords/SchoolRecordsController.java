package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    Scanner scanner = new Scanner(System.in);

    private ClassRecords classRecords;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();


    public ClassRecords getClassRecords() {
        return classRecords;
    }

    public void setClassRecords(ClassRecords classRecords) {
        this.classRecords = classRecords;
    }

    public void initSchool() {
        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("földrajz"));
        subjects.add(new Subject("biológia"));
        subjects.add(new Subject("zene"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("kémia"));
        subjects.add(new Subject("magyar"));
        subjects.add(new Subject("történelem"));
        subjects.add(new Subject("testnevelés"));
        subjects.add(new Subject("informatika"));
        subjects.add(new Subject("angol"));

        tutors.add(new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("matematika"), new Subject("fizika"))));
        tutors.add(new Tutor("Kovács Rita",
            Arrays.asList(new Subject("földrajz"), new Subject("zene"))));
        tutors.add(new Tutor("Varga Márton",
            Arrays.asList(new Subject("biológia"), new Subject("kémia"))));
        tutors.add(new Tutor("Nagy Béla",
            Arrays.asList(new Subject("matematika"), new Subject("testnevelés"))));
        tutors.add(new Tutor("Jókai Ferenc",
            Arrays.asList(new Subject("magyar"), new Subject("történelem"))));
        tutors.add(new Tutor("Neumann János",
            Arrays.asList(new Subject("angol"), new Subject("informatika"))));
    }

    public void menuPointsToDisplay () {
        System.out.println("\t\t1. Diákok nevének listázása\n" +
                "\t\t2. Diák név alapján keresése\n" +
                "\t\t3. Diák létrehozása\n" +
                "\t\t4. Diák név alapján törlése\n" +
                "\t\t5. Diák feleltetése\n" +
                "\t\t6. Osztályátlag kiszámolása\n" +
                "\t\t7. Tantárgyi átlag kiszámolása\n" +
                "\t\t8. Diákok átlagának megjelenítése\n" +
                "\t\t9. Diák átlagának kiírása\n" +
                "\t\t10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "\t\t11. Kilépés");
    }

    public int changeMenuPoint() {
        int menuPoint = 0;
        System.out.print("Menüpont: ");
        menuPoint = scanner.nextInt();
        scanner.nextLine();
        return menuPoint;
    }
    public void listOfStudents(ClassRecords classRecords){
        System.out.println(classRecords.listStudentNames());
    }

    public Student findByNameOfStudent(ClassRecords classRecords) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a tanuló nevét: ");
        String name = scanner.nextLine();
        Student student = classRecords.findStudentByName(name);
        System.out.println(student.getName());
        return student;
    }

    public ClassRecords createStudent(ClassRecords classRecords) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a tanuló nevét: ");
        String name = scanner.nextLine();
        classRecords.addStudent(new Student(name));
        return classRecords;
    }

    public ClassRecords removeByNameOfStudent(ClassRecords classRecords) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a törölni kívánt tanuló nevét: ");
        String name = scanner.nextLine();
        Student student = new Student(name);
        System.out.println(classRecords.removeStudent(student));
        return classRecords;
    }

    public void answeringByStudent() {
        //
    }

    public void classAverage() {
        //
    }

    public void subjectAverage() {
        //
    }

    public void showAverageStudents() {
        //
    }

    public void studentAverageDisplay() {
        //
    }

    public void studentAverageForSubjectDisplay() {

        //
    }

    public static void main(String[] args) {

        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        ClassRecords classRecords1 = new ClassRecords("First class", new Random(5));
        schoolRecordsController.initSchool();

        int changeMenuPointValue= 0;
        do {
            if (changeMenuPointValue != 12) schoolRecordsController.menuPointsToDisplay();
            changeMenuPointValue = schoolRecordsController.changeMenuPoint();
            switch (changeMenuPointValue) {
                case 1 : schoolRecordsController.listOfStudents(classRecords1); break;
                case 2 : schoolRecordsController.findByNameOfStudent(classRecords1); break;
                case 3 : classRecords1 = schoolRecordsController.createStudent(classRecords1); break;
                case 4 : classRecords1 = schoolRecordsController.removeByNameOfStudent(classRecords1); break;
                case 5 : schoolRecordsController.answeringByStudent(); break;
                case 6 : schoolRecordsController.classAverage(); break;
                case 7 : schoolRecordsController.subjectAverage(); break;
                case 8 : schoolRecordsController.showAverageStudents(); break;
                case 9 : schoolRecordsController.studentAverageDisplay(); break;
                case 10 :schoolRecordsController.studentAverageForSubjectDisplay(); break;
                case 11 : break;
                default : {
                    System.out.println("Nincs ilyen Menüpont! 1 .. 11 között lehet választani.");
                    changeMenuPointValue = 12;
                }
            }
        }
        while (changeMenuPointValue!=11);
    }
}
