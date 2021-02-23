package __practice;

public class CvdCheck {

    private final static int NUMBER_OF_DIGITS_IN_CVD = 10;

    public boolean check(String cvd) {
        exactly10Digits(cvd);
        int sum1_9Digit = 0;
        int digitValue;
        for (int digitPos = 1; digitPos < NUMBER_OF_DIGITS_IN_CVD; digitPos++) {
            digitValue = Character.getNumericValue(cvd.charAt(digitPos - 1));
            sum1_9Digit += digitPos * digitValue;
        }
        int lastDigit = Character.getNumericValue(cvd.charAt(NUMBER_OF_DIGITS_IN_CVD - 1));
        return sum1_9Digit % 11 == lastDigit;
    }

    private void exactly10Digits(String cvd) {
        if (cvd.length() != NUMBER_OF_DIGITS_IN_CVD) {
            throw new IllegalArgumentException("must be 10 digits");
        }
        for (char ch : cvd.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("this is not digit: " + ch);
            }
        }
    }
}