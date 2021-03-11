package exam03retake01;

import java.util.Arrays;

public class CdvCheck {

    private static final int CDV_DIGIT_NUMBER = 10;

    public boolean check(String s) {
        if (s.length() != CDV_DIGIT_NUMBER || notNumber(s)) {
            throw new IllegalArgumentException("A számjegyek száma nem 10");
        }
        int sum = 0;
        for (int i = 0; i < CDV_DIGIT_NUMBER - 1; i++) {
//            int digit = Integer.parseInt(s.substring(i, i + 1));
//            int digit = Integer.parseInt(Character.toString(s.charAt(i)));
//            int digit = s.charAt(i) - '0';
            int digit = Character.getNumericValue(s.charAt(i));
            sum += digit * (i + 1);
        }
        int lastDigit = Character.getNumericValue(s.charAt(9));
        return sum % 11 == lastDigit;
    }

    private boolean notNumber(String s) {
        for (int i = 0; i < CDV_DIGIT_NUMBER; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException("Ez nem szám: " + s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CdvCheck().check("8365670003"));
    }
}
