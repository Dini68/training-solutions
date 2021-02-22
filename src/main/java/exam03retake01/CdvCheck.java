package exam03retake01;

public class CdvCheck {

    public boolean check(String cdv) {
        if (cdv.length() != 10 ) {
            throw new IllegalArgumentException("no 10 digits.");
        }
        boolean isValid = false;
        int result = 0;
        String[] cdvArr = cdv.split("");
        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(cdv.charAt(i))) {
                throw new IllegalArgumentException("This is not digit");
            }
            result += Integer.parseInt(cdvArr[i]) * (i+1);
        }
        if (!Character.isDigit(cdv.charAt(9))) {
            throw new IllegalArgumentException("This is not digit");
        }
        return result % 11 == Integer.parseInt(cdvArr[9]);
    }
}
