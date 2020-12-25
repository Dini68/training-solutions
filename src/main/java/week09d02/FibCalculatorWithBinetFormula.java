package week09d02;

public class FibCalculatorWithBinetFormula {

    public int fibonacci(int i) {
        double sq5 = Math.sqrt(5);
        return (int)Math.round((Math.pow(1 + sq5, i) - Math.pow(1 - sq5, i)) / sq5 / Math.pow(2, i));
    }

    public int sumEvens(int bound) {  // Binet-formulával
        int sumEvens = 0;
        int i = 0;
        while (fibonacci(i + 1) <= bound) {
            if(fibonacci(i) % 2 == 0) {
                sumEvens += fibonacci(i);
            }
            i++;
        }
        return sumEvens;
    }
}
