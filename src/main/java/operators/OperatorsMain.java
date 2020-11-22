package operators;

import java.util.Random;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();
        Random rnd = new Random();

        int number = rnd.nextInt(1000);
        System.out.println(number + " páros? " + operators.isEven(number));

        System.out.println(16 >> 1);
        System.out.println(16 << 1);

        System.out.println(13 >> 1);
        System.out.println(13 << 1);

        System.out.println(operators.multiplyByPowerOfTwo(5, 5));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
//        int j = Integer.parseInt(s, 2);
        System.out.println(j);

        System.out.println(0333);
        // oktális számrendszerben van megadva 3*64+3*8+3 = 219
    }
}
