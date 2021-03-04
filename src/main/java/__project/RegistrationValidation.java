package __project;

import activitytracker.Activity;
import activitytracker.TrackPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationValidation {

    public boolean checkName(String fullName) {
        if (fullName.isBlank()) {
            System.out.println("A név nem lehet üres!");
            return false;
        }
        return true;
    }


    public String checkZip(List<String> cities) {
        if (cities.size() == 1) {
            return cities.get(0);
        }
        if (cities.size() > 1) {
            return whichCityIfMoreThanOne(cities);
        }
        System.out.println("Nincs ilyen irányítószám!");
        return "";
    }

    private String whichCityIfMoreThanOne(List<String> cities) {
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + 1 + ". " + cities.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem válasszon: ");
        String ans = scanner.nextLine();
        if (!Character.isDigit(ans.charAt(0)) || ans.length() !=1) {
            throw new IllegalArgumentException("Ez nem számjegy.");
        }
        return cities.get(Integer.parseInt(ans) - 1);
    }

    private String getCityFromLine(String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < line.split(";").length; i++) {
            if (i > 1) sb.append(", ");
            sb.append(line.split(";")[i].trim());
        }
        return sb.toString();
    }

    public boolean checkAge(int age) {
        if (!(age > 10 && age < 150)) {
            System.out.println("Az életkornak 10 és 150 közé kell esnie!");
            return false;
        }
        return true;
    }

    public boolean checkEmail(String email) {
        if (!email.contains("@")) {
            System.out.println("Hiányzik a '@' karakter!");
            return false;
        }
        if (!email.contains(".")) {
            System.out.println("Hiányzik a '.' karakter!");
            return false;
        }
        if (email.startsWith("@")) {
            System.out.println("Nem kezdődhet '@' karakterrel!");
            return false;
        }
        if (email.endsWith(".")) {
            System.out.println("Nem végződhet '.' karakterrel!");
            return false;
        }
        if (email.length() < 5) {
            System.out.println("Minimum legyen 5 karakter!");
            return false;
        }
        if (email.indexOf('@') > email.indexOf('.') - 2) {
            System.out.println("a '@' karakter után minimum kettővel '.' kell legyen!");
            return false;
        }
        int count_1 = 0;
        int count_2 = 0;
        for (char c: email.toCharArray()) {
            if (c == '@') {
                count_1 ++;
            }
            if (c == '.') {
                count_2 ++;
            }
        }
        if (count_1 != 1 || count_2 != 1) {
            System.out.println("pontosan 1 '@' és 1 '.' karakter lehet.");
            return false;
        }
        return true;
    }

    public boolean checkSocialSecurityNumber(String socialSecurityNumber) {
        if (socialSecurityNumber.length() != 9) {
            System.out.println("A TAJ számnak 9 számjegyűnek kell lennie!");
            return false;
        }
        int odd = 0;
        int even = 0;
        int count = 0;
        for (char c: socialSecurityNumber.toCharArray()) {
            if (count == 8 && (odd * 3 + even * 7) % 10 != Character.getNumericValue(c)) {
                System.out.println("Ez nem TAJ szám!");
                return false;
            }
            if (count % 2 == 0) {
                odd += Character.getNumericValue(c);
            }
            if (count % 2 == 1) {
                even += Character.getNumericValue(c);
            }
            count ++;
        }
        return true;
    }


}
