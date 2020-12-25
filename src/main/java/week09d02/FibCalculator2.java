package week09d02;

public class FibCalculator2 {

    public int sumEvens(int bound) {  // Ez addig adja össze, amíg a következő Fibonacci-szám nem nagyobb a bound-nál,
        int sumEvens = 0;             // sztem ez volt a feladat.
        int fib1 = 0;
        int fib2 = 1;
        int temp = 0;
        int fibNext = fib1 + fib2;
        while (fibNext <= bound) {
            if (fib2 % 2 == 0) {
                sumEvens += fib2;
            }
            temp = fib2;
            fibNext += fib2;
            fib2 += fib1;
            fib1 = temp;
        }
        return sumEvens;
    }

    public static void main(String[] args) {
        FibCalculator2 fibCalculator2 = new FibCalculator2();
        System.out.println(fibCalculator2.sumEvens(2));
    }
}
