package week09d02;

public class FibCalculator {

    public int sumEvens(int bound) {  // Ez addig adja össze, amíg a Fibonacci-szám nem nagyobb a bound-nál,
        int sumEvens = 0;             // de a következőt Fibonacci-számot kell figyelni.
        int fib1 = 0;
        int fib2 = 1;
        int temp = 0;
        int fibNext = fib1 + fib2;
        while (fibNext <= bound) {
            if (fibNext % 2 == 0) {
                sumEvens += fibNext;
            }
            temp = fib2;
            fibNext += fib2;
            fib2 += fib1;
            fib1 = temp;
        }
        return sumEvens;
    }

    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculator();
        System.out.println(fibCalculator.sumEvens(2));
    }
}
