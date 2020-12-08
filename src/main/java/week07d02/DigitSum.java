package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {
        if (x < 0) {
            x = -x;
        }
        int sum = 0;
        while ( x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new DigitSum().sumOfDigits(0));
    }
}
