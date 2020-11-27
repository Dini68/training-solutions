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
        switch (menuPoint) {
            case 1 : listOfStudents(); break;
            case 2 : findByNameOfStudent(); break;
            case 3 : createStudent(); break;
            case 4 : removeByNameOfStudent(); break;
            case 5 : answeringByStudent(); break;
            case 6 : classAverage(); break;
            case 7 : subjectAverage(); break;
            case 8 : showAverageStudents(); break;
            case 9 : studentAverageDisplay(); break;
            case 10 : studentAverageForSubjectDisplay(); break;
            case 11 : break;
            default : {
                System.out.println("Nincs ilyen Menüpont! 1 .. 11 között lehet választani.");
                menuPoint = 12;
            }
        }
        return menuPoint;
    }
    public void listOfStudents() {
        classRecords.listStudentNames();
    }

    public void findByNameOfStudent() {
        //
    }

    public void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a tanuló nevét: ");
        String name = scanner.nextLine();
        classRecords.addStudent(new Student(name));
    }

    public void removeByNameOfStudent() {
        //
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
        ClassRecords classRecords = new ClassRecords("First class", new Random(5));
        schoolRecordsController.initSchool();

        int changeMenuPointValue= 0;
        do {
            if (changeMenuPointValue != 12) schoolRecordsController.menuPointsToDisplay();
            changeMenuPointValue = schoolRecordsController.changeMenuPoint();
        }
        while (changeMenuPointValue!=11);
    }
}
