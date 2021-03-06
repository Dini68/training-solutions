package __project;

import org.mariadb.jdbc.MariaDbDataSource;
import stringtype.registration.Registration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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
                case 2 : vm.bulkRegistration(cd); break;
                case 3 : vm.generate(cd); break;
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

    private void generate(CitizenDao cd) {
        System.out.print("Kérem az irányítószámot: ");
        String zip = scanner.nextLine();
        System.out.print("Kérem a mentett fájl nevét: ");
        String fileName = scanner.nextLine();
        List <String> genList = new ArrayList<>(cd.selectByZipAndAge(zip));
//        System.out.println(cd.selectByZipAndAge(zip));
//        try (BufferedWriter bw = Files.newBufferedWriter(file, Charset.forName("ISO-8859-2"))){
        Path file = Path.of(fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(file)){
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám;beoltás száma;beoltás ideje\n");
            for (String s: genList) {
                bw.write(s + "\n");
                System.out.println(s);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("cannot write file", ioException);
        }

    }

    private void bulkRegistration(CitizenDao cd) {
        System.out.print("Kérem a fájl elérési útvonalát: ");
        String path = scanner.nextLine();
        RegistrationValidation rv = new RegistrationValidation();
        StringBuilder errorList = new StringBuilder();
        errorList.append("Hibásan megadott regisztrációk: \n");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))){
            String header = reader.readLine();
            String line;
            Boolean validReg;
            String error = "";
            while ((line = reader.readLine()) != null) {
                String fullName = line.split(",")[0];
                validReg = rv.checkName(fullName);
                if (!validReg) {
                    error = "Hibás név megadás: " + fullName;
                }

                String zip = (line.split(",")[1]);
                if (validReg) {
                    validReg = !rv.checkZip(cd.selectByZip(zip)).equals("");
                    error = "Hibás irányítószám: " + zip;
                }

                int age = Integer.parseInt(line.split(",")[2]);
                if (validReg) {
                    validReg = rv.checkAge(age);
                    error = "Hibás életkor: " + age;
                }
                String email = line.split(",")[3];
                if (validReg) {
                    validReg = rv.checkEmail(email);
                    error = "Hibás email" + email;
                }

                String ssn = line.split(",")[4];
                if (validReg) {
                    validReg = rv.checkSocialSecurityNumber(ssn);
                    error = "Hibás TAJ szám: " + ssn;
                }

                if (validReg) {
                    cd.insertCitizen(new Citizen(fullName, zip, age, email, ssn));
                }
                else {
                    System.out.println(line + " >>> " + error + "\n");
                    errorList.append("\t" + line + " >>> " + error + "\n");
                }
            }
            System.out.println(errorList);
            try {
                Files.writeString(Path.of("hibalista.txt"), errorList);
            }
            catch (IOException ioe) {
                throw new IllegalStateException("Can not write file", ioe);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("cannot read file.", ioException);
        }
    }

    private void registration(CitizenDao  cd) {
        RegistrationValidation rv = new RegistrationValidation();

        String fullName = "";
        do {
            System.out.println("\t\t>>> Visszalépés a főmenübe - > x");
            System.out.print("Kérem a nevet: ");
            fullName = scanner.nextLine();
            if (fullName.toLowerCase().equals("x")) {
                return;
            }
        }
        while (!rv.checkName(fullName));

        String zip = "";
        String city = "";
        do {
            System.out.println("\t\t>>> Visszalépés a főmenübe - > x");
            System.out.print("Kérem az irányítószámot: ");
            zip = scanner.nextLine();
            if (zip.toLowerCase().equals("x")) {
                return;
            }
            city = rv.checkZip(cd.selectByZip(zip));
        }
        while (city.equals(""));
        System.out.println(city);

        String age = "";
        do {
            System.out.println("\t\t>>> Visszalépés a főmenübe - > x");
            System.out.print("Kérem az életkort: ");
            age = scanner.nextLine();
            if (age.toLowerCase().equals("x")) {
                return;
            }
        }
        while (!rv.checkAge(Integer.parseInt(age)));

        String email = "";
        do {
            System.out.println("\t\t>>> Visszalépés a főmenübe - > x");
            System.out.print("Kérem az emailt: ");
            email = scanner.nextLine();
            if (email.toLowerCase().equals("x")) {
                return;
            }
        }
        while (!rv.checkEmail(email));

        String ssn = "";
        do {
            System.out.println("\t\t>>> Visszalépés a főmenübe - > x");
            System.out.print("Kérem a TAJ számot: ");
            ssn = scanner.nextLine();
            if (ssn.toLowerCase().equals("x")) {
                return;
            }
        }
        while (!rv.checkSocialSecurityNumber(ssn));

        System.out.println("Név: " + fullName);
        System.out.println("Irányítószám: " + zip);
        System.out.println("Város: " + city);
        System.out.println("Életkor: " + age);
        System.out.println("Email: " + email);
        System.out.println("TAJ szám: " + ssn);

        System.out.print("Az adatok helyesek? (y) ");
        String yes = scanner.nextLine();
        if (yes.toLowerCase().equals("y")) {
            Citizen actualCitizen = new Citizen(fullName, zip, Integer.parseInt(age), email, ssn, city);
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

