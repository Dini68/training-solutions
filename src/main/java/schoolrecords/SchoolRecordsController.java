package schoolrecords;

import java.util.*;

import static schoolrecords.MarkType.*;

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
        System.out.println("\n\t\t1. Diákok nevének listázása\n" +
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
        System.out.print("\nMenüpont: ");
        menuPoint = scanner.nextInt();
        scanner.nextLine();
        return menuPoint;
    }
    public void listOfStudents(){       // 1.
        System.out.print("Diákok névsora: " + classRecords.listStudentNames());
        System.out.print("\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void findByNameOfStudent() {     // 2.
        System.out.print("Kérem a tanuló nevét: ");
        Student student = classRecords.findStudentByName(scanner.nextLine());
//        System.out.print(student.getName());
        System.out.print("Megtaláltam a listában!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void createStudent() {   // 3.
        System.out.print("Kérem a tanuló nevét: ");
        String name = scanner.nextLine();
        classRecords.addStudent(new Student(name));
        System.out.print("\"" + name + "\"" + " felvéve a listába!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void removeByNameOfStudent() {   // 4.
        System.out.print("Kérem a törölni kívánt tanuló nevét: ");
        String name = scanner.nextLine();
        if (classRecords.removeStudent(classRecords.findStudentByName(name))) {
            System.out.print("\"" + name + "\"" + " törölve a listából!\n\t\t>>> folytatás 'Enter' gombbal");
        }
        scanner.nextLine();
    }

    public void answeringByStudent() {      // 5.
        Student student;
        student = classRecords.repetition();
        System.out.print("Érdemjegy: ");
        String givenMark = scanner.nextLine();
        System.out.print("Tantárgy neve: ");
        String givenSubject = scanner.nextLine();
        System.out.print("Tanár: ");
        String givenTutor = scanner.nextLine();

        boolean isTutorAndSubject = false; // létezik a tanár és tanítja is a tárgyat
        int tutorIndex = 0;
        int subjektIndex = 0;

        for (Tutor tr: tutors) {
            if (tr.getName().equals(givenTutor)) {
                for (Subject sb: subjects) {
                    if (sb.getSubjectName().equals(givenSubject)) {
                        isTutorAndSubject = true;
                        break;
                    }
                    subjektIndex++;
                }
                if (isTutorAndSubject) {
                    break;
                }
                tutorIndex++;
            }
        }

        if (!isTutorAndSubject) return;

        Mark mark = new Mark(A, subjects.get(subjektIndex), tutors.get(tutorIndex));
        switch (givenMark) {
            case "5":
                mark = new Mark(A, subjects.get(subjektIndex), tutors.get(tutorIndex));
                break;
            case "4":
                mark = new Mark(B, subjects.get(subjektIndex), tutors.get(tutorIndex));
                break;
            case "3":
                mark = new Mark(C, subjects.get(subjektIndex), tutors.get(tutorIndex));
                break;
            case "2":
                mark = new Mark(D, subjects.get(subjektIndex), tutors.get(tutorIndex));
                break;
            case "1":
                mark = new Mark(F, subjects.get(subjektIndex), tutors.get(tutorIndex));
                break;
        }
        student.grading(mark);
        System.out.print(student.getName() + " osztályozva!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void classAverage() {        // 6.
        System.out.println(classRecords.calculateClassAverage());
        System.out.print("Osztályátlag kész!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void subjectAverage() {      // 7.
        System.out.print("Tantárgy neve: ");
        String givenSubject = scanner.nextLine();
        System.out.println(classRecords.calculateClassAverageBySubject( new Subject(givenSubject)));
        System.out.print("Tantárgyi átlag kész!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void showAverageStudents() {     // 8.
        List<StudyResultByName> lsrbn = new ArrayList<>();
        lsrbn = classRecords.listStudyResults();
        for (int i = 0; i < lsrbn.size(); i++ ) {
            System.out.println(classRecords.listStudyResults().get(i).getStudentName() +
                        " " + (classRecords.listStudyResults().get(i).getStudyAverage()));
        }
        System.out.print("Diákok átlagának megjelenítése kész!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void studentAverageDisplay() {       // 9.
        System.out.print("Kérem a diák nevét: ");
        String name = scanner.nextLine();
        System.out.println(name + ": " + classRecords.findStudentByName(name).calculateAverage());
        System.out.print("Diák átlagának kiírása\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public void studentAverageForSubjectDisplay() {     // 10.
      //  Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a tanuló nevét: ");
        String name = scanner.nextLine();
        System.out.print("Kérem a tantárgy nevét: ");
        String subjectName = scanner.nextLine();
        Student student = classRecords.findStudentByName(name);
        System.out.println(name + ": " + subjectName + ": " + student.calculateSubjectAverage(new Subject(subjectName)));
        System.out.print("Diák tantárgy átlagának kiírása kész!\n\t\t>>> folytatás 'Enter' gombbal");
        scanner.nextLine();
    }

    public static void main(String[] args) {

        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.setClassRecords(new ClassRecords("First class", new Random(5)));
//        ClassRecords classRecords1 = new ClassRecords("First class", new Random(5));
        schoolRecordsController.initSchool();

        int changeMenuPointValue= 0;
        do {
            if (changeMenuPointValue != 12) schoolRecordsController.menuPointsToDisplay();
            changeMenuPointValue = schoolRecordsController.changeMenuPoint();
            switch (changeMenuPointValue) {
                case 1 : schoolRecordsController.listOfStudents(); break;
                case 2 : schoolRecordsController.findByNameOfStudent(); break;
                case 3 : schoolRecordsController.createStudent(); break;
                case 4 : schoolRecordsController.removeByNameOfStudent(); break;
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
