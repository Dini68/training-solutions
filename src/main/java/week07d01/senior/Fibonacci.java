package week07d01.senior;

public class Fibonacci {



    public static long fib(int n) {
        long result = 0;
        if (n < 0) {
            throw new IllegalArgumentException("Wrong param: " + n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (RESULTS[n] == null) {
            RESULTS[n] = fib(n - 2) + fib(n - 1);

        }
//        long n0 = 0;
//        long n1 = 1;
//        for (int i = 2; i <= n; i++) {
//            result = n0 + n1;
//            n0 = n1;
//            n1 = result;
//        }
//        return fib(n - 2) + fib(n - 1);
        return RESULTS[n];
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(500));
        System.out.println(fibonacci.fib(8));
    }

    private static final Long[] RESULTS = new Long[2000];

}
