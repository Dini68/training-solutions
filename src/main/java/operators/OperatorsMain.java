package operators;

import java.util.Random;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();
        Random rnd = new Random();

        int number = rnd.nextInt(1000);
        System.out.println(number + " páros? " + operators.isEven(number));

    }
}
