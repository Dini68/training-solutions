package week07d01;

public class MathAlgorithms {

    public boolean isPrime(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Nem lehet 1-nél kisebb a paraméter!");
        }
        boolean isPr = true;
        if (x == 1) isPr = false;
        int i = 2;
        while (i <= Math.sqrt(x) && isPr) {
            if (x % i == 0) {
                i ++;
                isPr = false;
            }
            i++;
        }
        return isPr;
    }

    public static void main(String[] args) {
        MathAlgorithms m = new MathAlgorithms();
        System.out.println(m.isPrime(1));
        System.out.println(m.isPrime(2));
        System.out.println(m.isPrime(3));
        System.out.println(m.isPrime(4));
        System.out.println(m.isPrime(5));
        System.out.println(m.isPrime(6));
        System.out.println(m.isPrime(7));
        System.out.println(m.isPrime(8));
        System.out.println(m.isPrime(9));
        System.out.println(m.isPrime(10));
        System.out.println(m.isPrime(11));
        System.out.println(m.isPrime(12));
    }
}
