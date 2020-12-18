package week08d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int a, int b) {
        int lnko = 1;
        Math.min(a,b);
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                lnko = i;
            }
        }
        return lnko;
    }

    public static void main(String[] args) {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        System.out.println(mathAlgorithms.greatestCommonDivisor(6,11));
    }
}
