package __project;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaccinationManagement {

    private Scanner scanner = new Scanner(System.in);

    private List<Citizen> citizens = new ArrayList<>();

    public List<Citizen> getCitizens() {
        return new ArrayList<>(citizens);
    }

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccine?useUnicode=true");
            dataSource.setUser("vaccine");
            dataSource.setPassword("vaccine");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        CitizenDao cd = new CitizenDao(dataSource);

        VaccinationManagement vm = new VaccinationManagement();
        int menuPoint= 0;
        do {
            if (menuPoint != 8) vm.menuItemsToDisplay();
            menuPoint = vm.selectMenuPoint();

            switch (menuPoint) {
                case 1 : vm.registration(cd); break;
                case 2 : vm.bulkRegistration(); break;
                case 3 : vm.generate(); break;
                case 4 : vm.vaccination(); break;
                case 5 : vm.vaccinationFailed(); break;
                case 6 : vm.report(); break;
                case 7 : vm.exit(); break;
                default : {
                    System.out.println("Nincs ilyen menüpont! 1 .. 7 között lehet választani.");
                    menuPoint = 8;
                }
            }
        }
        while (menuPoint != 7);

    }

    private int selectMenuPoint() {
        int selectedItem;
        System.out.print("\nKérem a menüpontot: ");
        selectedItem = scanner.nextInt();
        scanner.nextLine();
        return selectedItem;
    }

    private void exit() {

    }

    private void report() {
    }

    private void vaccinationFailed() {
    }

    private void vaccination() {
    }

    private void generate() {
    }

    private void bulkRegistration() {
    }

    private void registration(CitizenDao  cd) {
        RegistrationValidation rv = new RegistrationValidation();

        String fullName = "";
        do {
            System.out.print("Kérem a nevet: ");
            fullName = scanner.nextLine();
        }
        while (!rv.checkName(fullName));

        String zip = "";
        String city = "";
        do {
            System.out.print("Kérem az irányítószámot: ");
            zip = scanner.nextLine();
            city = rv.checkZip(cd.selectByZip(zip));
        }
        while (city.equals(""));
        System.out.println(city);

        int age = 0;
        do {
            System.out.print("Kérem az életkort: ");
            age = scanner.nextInt();
            scanner.nextLine();
        }
        while (!rv.checkAge(age));

        String email = "";
        do {
            System.out.print("Kérem az emailt: ");
            email = scanner.nextLine();
        }
        while (!rv.checkEmail(email));

        String ssn = "";
        do {
            System.out.print("Kérem a TAJ számot: ");
            ssn = scanner.nextLine();
        }
        while (!rv.checkSocialSecurityNumber(ssn));

        System.out.println("Név: " + fullName);
        System.out.println("Irányítószám: " + zip);
        System.out.println("Város: " + city);
        System.out.println("Életkor: " + age);
        System.out.println("Email: " + email);
        System.out.println("TAJ szám: " + ssn);

        System.out.print("Az adatok helyesek?");
        String yes = scanner.nextLine();
        if (yes.toLowerCase().equals("y")) {
            Citizen actualCitizen = new Citizen(fullName, zip, age, email, ssn, city);
            citizens.add(actualCitizen);
            cd.insertCitizen(actualCitizen);
            System.out.println("felvéve");
            System.out.println(getCitizens().get(getCitizens().size()-1));
        }


    }

    public void menuItemsToDisplay () {
        System.out.println("""

                \t\t1. Regisztráció
                \t\t2. Tömeges regisztráció
                \t\t3. Generálás
                \t\t4. Oltás
                \t\t5. Oltás meghiúsulás
                \t\t6. Riport
                \t\t7. Kilépés""");
    }

}
//        cd.insertCitizen(new Citizen("KD", "4224", 12, "kdini68@gmail.com", "027919396"));
//        cd.insertCitizen(new Citizen("SF", "1181", 152, "kdini68@gmail.com", "123456788"));
//        cd.insertCitizen(new Citizen("KD", "1031", 52, "kdini68@gmail.com", "123456788"));

//        System.out.println(new Citizen("KD", "4224", 12, "kdini68@gmail.com", "027919396"));
//        System.out.println(new Citizen(null, "1181", 152, "kdini68@gmail.com", "123456788"));
//        System.out.println(new Citizen("KD", "1031", 52, "kdini68@gmail.com", "123456788"));

