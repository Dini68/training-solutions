package __practice;

public class CvdCheck {

    public boolean check(String cvd) {
        exactly10Digits(cvd);
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += charToInt(cvd.charAt(i)) * (i + 1);
        }
        return sum % 11 == charToInt(cvd.charAt(9));
    }

    private int charToInt(char ch) {
        return ch - 48;
    }

    private void exactly10Digits(String cvd) {
        if (cvd.length() != 10) {
            throw new IllegalArgumentException("must be 10 digits");
        }
        for (char ch : cvd.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("no digit: " + ch);
            }
        }
    }
}