package introexception;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        boolean isValid = true;
        String validNumbers = "0123456789";
        if (ssn.length() != 9) {
            throw new IllegalArgumentException("TAJ számnak 9 számjegynek kell lennie!");
        }
        String[] ssnChar = ssn.split("");
        for (int i = 0; i < ssnChar.length - 1; i++) {
            if (!validNumbers.contains(ssnChar[i])) {
                throw new IllegalArgumentException("A TAJ számban csak számjegyek lehetnek!");
            }
        }
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < ssnChar.length - 1; i++) {
            if (i % 2 == 0) {
                sumEven += Integer.parseInt(ssnChar[i]);
            }
            if (i % 2 == 1) {
                sumOdd += Integer.parseInt(ssnChar[i]);
            }
        }
        if ((sumEven * 3 + sumOdd * 7) % 10 != Integer.parseInt(ssnChar[8])) {
            isValid = false;
        }

        return isValid;
    }
}
